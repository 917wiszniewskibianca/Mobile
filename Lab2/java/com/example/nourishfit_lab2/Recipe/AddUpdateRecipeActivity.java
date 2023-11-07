package com.example.nourishfit_lab2.Recipe;

import static com.example.nourishfit_lab2.R.id.save_recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nourishfit_lab2.R;

public class AddUpdateRecipeActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "com.example.nourishfit_lab2.Recipe.EXTRA_TITLE";

    public static final String EXTRA_DESCRIPTION =
            "com.example.nourishfit_lab2.Recipe.EXTRA_DESCRIPTION";
    public static final String EXTRA_INSTRUCTIONS =
            "com.example.nourishfit_lab2.Recipe.EXTRA_INSTRUCTIONS";
    public static final String EXTRA_USER =
            "com.example.nourishfit_lab2.Recipe.EXTRA_USER";
    public static final String EXTRA_IMAGE =
            "com.example.nourishfit_lab2.Recipe.EXTRA_IMAGE";

    public static final String EXTRA_ID =
            "com.example.nourishfit_lab2.Recipe.EXTRA_ID";
    private EditText title;
    private EditText description;

    private EditText instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        findViews();

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if( intent.hasExtra(EXTRA_ID)){
            setTitle("Edit recipe");
            title.setText(intent.getStringExtra(EXTRA_TITLE));
            description.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            instructions.setText(intent.getStringExtra(EXTRA_INSTRUCTIONS));
        }
        else {setTitle("Add Recipe");}

    }

    private void saveRecipe(){
        String recipeTitle = this.title.getText().toString();
        String recipeDescription = this.description.getText().toString();
        String recipeInstructions = this.instructions.getText().toString();

        if(recipeTitle.trim().isEmpty() || recipeDescription.trim().isEmpty() || recipeInstructions.trim().isEmpty()){
            Toast.makeText(this,"Please insert the title,description and instructions",Toast.LENGTH_LONG).show();
            return;
        }
        /////////////////////   TAKE THE USER \\\\\\\\\\\\\
        String user = "some_user";
        int image = R.drawable.resource_default;

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,recipeTitle);
        data.putExtra(EXTRA_DESCRIPTION,recipeDescription);
        data.putExtra(EXTRA_INSTRUCTIONS,recipeInstructions);
        data.putExtra(EXTRA_USER,user);
        data.putExtra(EXTRA_IMAGE,image);

        int id = getIntent().getIntExtra(EXTRA_ID,-1);
        if (id!=-1){
            data.putExtra(EXTRA_ID,id);

        }

        setResult(RESULT_OK,data);
        finish();
    }

    void findViews(){
        this.title = findViewById(R.id.edit_text_add_title);
        this.description = findViewById(R.id.edit_text_add_description);
        this.instructions = findViewById(R.id.edit_text_add_instructions);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_recipe_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== save_recipe) {
            saveRecipe();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}