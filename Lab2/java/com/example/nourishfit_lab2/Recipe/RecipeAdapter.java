package com.example.nourishfit_lab2.Recipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nourishfit_lab2.R;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private OnItemClickListener listener;

    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_layout, parent, false); // Use the correct layout name
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);
        holder.recipeImage.setImageResource(currentRecipe.getImage());
        holder.recipeTitle.setText(currentRecipe.getName());
        holder.recipeDescription.setText(currentRecipe.getDescription());

    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes =  recipes;
        notifyDataSetChanged();
    }


    public Recipe getRecipeAt(int position){
        return recipes.get(position);
    }




    class RecipeViewHolder extends RecyclerView.ViewHolder {
        private ImageView recipeImage;
        private TextView recipeTitle;
        private TextView recipeDescription;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.image_view_recipe_icon);
            recipeTitle = itemView.findViewById(R.id.text_view_recipe_title);
            recipeDescription = itemView.findViewById(R.id.text_view_recipe_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(recipes.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Recipe recipe);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
