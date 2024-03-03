package com.example.activitiesproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView startersCard;
    CardView mainsCard;
    CardView dessertsCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_mains);

        startersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO MOVE TO A NEW ACTIVITY WHEN SOMETHING IS CLICKED
                Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
                startActivity(startersActivityIntent);
            }
        });

        mainsCard = findViewById(R.id.card_view_mains);

        mainsCard.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mainsActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
                startActivity(mainsActivityIntent);
            }
        });

        dessertsCard = findViewById(R.id.card_view_desserts);

        dessertsCard.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mainsActivityIntent = new Intent(MainActivity.this, DessertsActivity.class);
                startActivity(mainsActivityIntent);
            }
        });

        TextView emailTextView = findViewById(R.id.text_view_email_adress);
        emailTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailto:thehungrydeveloper@bianca.com"));
                startActivity(launchEmailAppIntent);
            }
        });
    }
}