package com.example.nourishfit_lab2.Recipe;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nourishfit_lab2.Recipe.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {
// used to access the database
    @Insert
    void insert(Recipe recipe);

    @Update
    void update(Recipe recipe);

    @Delete
    void delete(Recipe recipe);


    // we can add our own query
    @Query("SELECT * FROM table_recipe")
    LiveData<List<Recipe>> getAllRecipes();

}
