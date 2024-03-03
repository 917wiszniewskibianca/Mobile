package com.example.activitiesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainCoursesActivity extends AppCompatActivity {

    private ListView mainsList;
    private ArrayList<Dish> dishList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_courses);
        initialiseDishes();
        mainsList =  findViewById(R.id.list_view_mains);

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1, this.dishList);

        this.mainsList.setAdapter(dishesAdapter);
    }

    private void initialiseDishes() {
        Dish firstDish = new Dish("Classic Spaghetti Carbonara", "Spaghetti with creamy sauce, pancetta, eggs, and Parmesan cheese.", 12.99);
        Dish secondDish = new Dish("Chicken Tikka Masala", "Tender pieces of chicken in a rich tomato and cream sauce.", 14.99);
        Dish thirdDish = new Dish("Sushi Delight", "Assorted sushi rolls and sashimi with fresh fish, rice, and seaweed.", 22.99);
        Dish fourthDish = new Dish("Margherita Pizza", "Pizza with tomato sauce, fresh mozzarella, basil leaves, and a drizzle of olive oil.", 11.99);
        Dish fifthDish = new Dish("Vegetable Pad Thai", "Stir-fried rice noodles with tofu or shrimp and a sweet and tangy tamarind sauce.", 13.99);
        Dish sixthDish = new Dish("Royal Burger", "A hearty beef burger with bacon, cheddar cheese, lettuce, tomato, and special sauce.", 9.99);
        Dish seventhDish = new Dish("Caesar Salad", "Romaine lettuce with croutons, parmesan cheese, and Caesar dressing.", 8.99);
        Dish eighthDish = new Dish("Mango Lassi", "A refreshing Indian drink with yogurt and ripe mango.", 4.99);
        Dish ninthDish = new Dish("Beef Stir-Fry", "Sliced beef with mixed vegetables in a savory stir-fry sauce.", 15.99);
        Dish tenthDish = new Dish("Chocolate Fondue", "A dessert with melted chocolate for dipping fruits, marshmallows, and cake pieces.", 10.99);
        Dish eleventhDish = new Dish("Gourmet Tacos", "Soft corn tortillas filled with gourmet options like grilled shrimp or carne asada.", 11.99);
        Dish twelfthDish = new Dish("Chicken Shawarma", "Marinated and sliced chicken in a pita wrap with tahini and vegetables.", 9.99);
        Dish thirteenthDish = new Dish("Eggplant Parmesan", "Sliced and breaded eggplant with marinara sauce and mozzarella cheese.", 12.99);
        Dish fourteenthDish = new Dish("Creamy Lobster Bisque", "A rich and creamy soup made from lobster, cream, and spices.", 16.99);
        Dish fifteenthDish = new Dish("Tandoori Salmon", "Salmon fillet marinated in tandoori spices, served with naan or rice.", 17.99);

        dishList.add(firstDish);
        dishList.add(secondDish);
        dishList.add(thirdDish);
        dishList.add(fourthDish);
        dishList.add(fifthDish);
        dishList.add(sixthDish);
        dishList.add(seventhDish);
        dishList.add(eighthDish);
        dishList.add(ninthDish);
        dishList.add(tenthDish);
        dishList.add(eleventhDish);
        dishList.add(twelfthDish);
        dishList.add(thirteenthDish);
        dishList.add(fourteenthDish);
        dishList.add(fifteenthDish);
    }

}