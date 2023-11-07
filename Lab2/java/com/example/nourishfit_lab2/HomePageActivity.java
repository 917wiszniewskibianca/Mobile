package com.example.nourishfit_lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nourishfit_lab2.Recipe.RecipesActivity;

public class HomePageActivity extends AppCompatActivity {

    private TextView quoteBox;
    private TextView remainingCaloriesBox;
    private CardView diaryCard;
    private CardView recipesCard;
    private CardView workoutCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        // when the page is loaded the remaining calories text should be updated
        // when the page is loaded the quote text should be updated

        findViews();
        setUpWorkoutOnClickListener();
        setUpDiaryOnClickListener();
        setUpRecipesOnClickListener();
    }

    private void findViews() {
        this.quoteBox = findViewById(R.id.text_view_quote);
        this.remainingCaloriesBox = findViewById(R.id.text_view_remaining_calories);
        this.diaryCard = findViewById(R.id.card_view_diary);
        this.recipesCard = findViewById(R.id.card_view_recipes);
        this.workoutCard = findViewById(R.id.card_view_workout);
    }

    private void setUpDiaryOnClickListener(){
        diaryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(HomePageActivity.this, DiaryActivity.class);
                startActivity(startersActivityIntent);
            }
        });
    }

    private void setUpRecipesOnClickListener(){
        recipesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(HomePageActivity.this, RecipesActivity.class);
                startActivity(startersActivityIntent);
            }
        });
    }

    private void setUpWorkoutOnClickListener(){
        workoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(HomePageActivity.this, WorkoutActivity.class);
                startActivity(startersActivityIntent);
            }
        });
    }

}