package com.example.nourishfit_lab2.Recipe;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nourishfit_lab2.Recipe.Recipe;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository repository;
    private LiveData<List<Recipe>> allRecipes;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        repository = new RecipeRepository(application);
        allRecipes = repository.getAllRecipes();
    }

    public void insert(Recipe recipe){
        repository.insert(recipe);
    }

    public void update(Recipe recipe){
        repository.update(recipe);
    }

    public void delete(Recipe recipe){
        repository.delete(recipe);
    }

   public LiveData<List<Recipe>> getAllRecipes(){
        return allRecipes;
   }

}
