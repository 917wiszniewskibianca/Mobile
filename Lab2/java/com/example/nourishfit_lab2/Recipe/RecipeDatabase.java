package com.example.nourishfit_lab2.Recipe;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.nourishfit_lab2.R;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Recipe.class} , version = 2 , exportSchema = false)
public abstract class RecipeDatabase extends RoomDatabase {

    private static RecipeDatabase instance ;

    public abstract RecipeDao recipeDao();
    public static synchronized RecipeDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), RecipeDatabase.class ,
                   "recipe_database_new1").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance ;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private RecipeDao recipeDao;
        private PopulateDbAsyncTask(RecipeDatabase db ){
            recipeDao = db.recipeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            recipeDao.insert(new Recipe("Shrimp Pasta", "410 kcal 30p", "Take the shrimp..", R.drawable.recipe1,"app"));
            recipeDao.insert(new Recipe("Chicken Salad", "370 kcal 41p","Chop the chicken.. ",  R.drawable.recipe2,"app"));
            recipeDao.insert(new Recipe("Pancakes", "500 kcal 28p","Blend the oats.. ",  R.drawable.recipe3,"app"));
            recipeDao.insert(new Recipe("Peas Soup", "230kcal 16p", "Blend everything.." ,R.drawable.recipe4,"app"));
            recipeDao.insert(new Recipe("Avocado Toast", "410kcal 22p","Take the avocado.. ",  R.drawable.recipe5,"app"));

            return null;
        }
    }

}
