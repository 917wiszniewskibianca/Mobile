package com.example.nourishfit_lab2.Recipe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nourishfit_lab2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class RecipesActivity extends AppCompatActivity {

    public static final int ADD_RECIPE_REQUEST = 1;
    public static final int UPDATE_RECIPE_REQUEST = 2;
    private RecipeViewModel recipeViewModel;
    private RecipeAdapter recipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        FloatingActionButton buttonAddRecipe = findViewById(R.id.button_add_recipe);
        buttonAddRecipe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipesActivity.this, AddUpdateRecipeActivity.class);
                startActivityForResult(intent, ADD_RECIPE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view_recipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeAdapter = new RecipeAdapter();
        recyclerView.setAdapter(recipeAdapter);

        recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                recipeAdapter.setRecipes(recipes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                showDeleteConfirmationDialog(viewHolder.getAdapterPosition());
               Toast.makeText(RecipesActivity.this, "Recipe deleted", Toast.LENGTH_LONG).show();
            }
        }).attachToRecyclerView(recyclerView);



        recipeAdapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(RecipesActivity.this, AddUpdateRecipeActivity.class);
                intent.putExtra(AddUpdateRecipeActivity.EXTRA_ID, recipe.getId());
                intent.putExtra(AddUpdateRecipeActivity.EXTRA_TITLE, recipe.getName());
                intent.putExtra(AddUpdateRecipeActivity.EXTRA_DESCRIPTION, recipe.getDescription());
                intent.putExtra(AddUpdateRecipeActivity.EXTRA_INSTRUCTIONS, recipe.getInstructions());

                startActivityForResult(intent, UPDATE_RECIPE_REQUEST);


            }
        });

    }

    void showDeleteConfirmationDialog(final int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RecipesActivity.this);
        builder.setMessage("Are you sure you want to delete this recipe?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked Yes button
                        deleteRecipe(pos);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked No button
                        dialog.dismiss(); // Close the dialog
                        Toast.makeText(RecipesActivity.this, "Recipe not deleted", Toast.LENGTH_LONG).show();
                        recipeAdapter.notifyItemChanged(pos);
                    }
                });

        builder.create().show();
    }


    private void deleteRecipe(int pos) {
        recipeViewModel.delete(recipeAdapter.getRecipeAt(pos));
        Toast.makeText(RecipesActivity.this, "Recipe deleted", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == ADD_RECIPE_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_DESCRIPTION);
            String instructions = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_INSTRUCTIONS);
            String user = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_USER);
            int image = data.getIntExtra(AddUpdateRecipeActivity.EXTRA_IMAGE, 1);

            Recipe recipe = new Recipe(title, description, instructions, image, user);
            recipeViewModel.insert(recipe);
            Toast.makeText(this, "Recipe saved", Toast.LENGTH_LONG).show();
        }else if( requestCode == UPDATE_RECIPE_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(AddUpdateRecipeActivity.EXTRA_ID,-1);
            if( id == -1){
                Toast.makeText(this, "Recipe cannot be updated", Toast.LENGTH_LONG).show();
                return ;
            }

            String title = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_DESCRIPTION);
            String instructions = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_INSTRUCTIONS);
            String user = data.getStringExtra(AddUpdateRecipeActivity.EXTRA_USER);
            int image = data.getIntExtra(AddUpdateRecipeActivity.EXTRA_IMAGE, 1);
            Recipe recipe = new Recipe(title, description, instructions, image, user);
            recipe.setId(id);
            recipeViewModel.update(recipe);
            Toast.makeText(this, "Recipe updated", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(this, "Recipe not saved", Toast.LENGTH_LONG).show();

        }
    }
}


