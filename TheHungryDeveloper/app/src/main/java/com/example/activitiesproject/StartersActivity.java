package com.example.activitiesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StartersActivity extends AppCompatActivity {

    private ListView startersList;
    private ArrayList<Dish> dishList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);
        initialiseDishes();
        startersList =  findViewById(R.id.list_view_starters);

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1, this.dishList);

        this.startersList.setAdapter(dishesAdapter);
    }

       private void initialiseDishes(){
           Dish firstDish = new Dish("Spaghetti Carbonara", "Classic Italian pasta dish with creamy sauce, pancetta, eggs, and Parmesan cheese.", 12.99);
           Dish secondDish = new Dish("Chicken Tikka Masala", "Tender pieces of chicken marinated in spices, served in a rich tomato and cream sauce.", 14.99);
           Dish thirdDish = new Dish("Sushi Platter", "Assorted sushi rolls and sashimi with fresh fish, rice, and seaweed, served with soy sauce and pickled ginger.", 22.99);
           Dish fourthDish = new Dish("Margarita Pizza", "A simple yet delicious pizza with tomato sauce, fresh mozzarella, basil leaves, and a drizzle of olive oil.", 11.99);
           Dish fifthDish = new Dish("Vegetable Pad Thai", "Stir-fried rice noodles with tofu or shrimp, bean sprouts, peanuts, and a sweet and tangy tamarind sauce.", 13.99);
           Dish sixthDish = new Dish("Burger Royale", "A hearty beef burger with bacon, cheddar cheese, lettuce, tomato, and special sauce, served with crispy fries.", 9.99);
           Dish seventhDish = new Dish("Caesar Salad", "Fresh romaine lettuce with croutons, parmesan cheese, and Caesar dressing, often topped with grilled chicken or shrimp.", 8.99);
           Dish eighthDish = new Dish("Mango Lassi", "A refreshing Indian drink made with yogurt, ripe mango, and a hint of cardamom.", 4.99);
           Dish ninthDish = new Dish("Beef Stir-Fry", "Sliced beef with mixed vegetables in a savory stir-fry sauce, served with steamed rice.", 15.99);
           Dish tenthDish = new Dish("Chocolate Fondue", "A delightful dessert featuring a pot of melted chocolate for dipping fruits, marshmallows, and cake pieces.", 10.99);
           Dish eleventhDish = new Dish("Gourmet Tacos", "Soft corn tortillas filled with various gourmet options such as grilled shrimp, carne asada, or vegan cauliflower.", 11.99);
           Dish twelfthDish = new Dish("Chicken Shawarma", "Marinated and thinly sliced chicken served in a pita wrap with tahini, vegetables, and garlic sauce.", 9.99);
           Dish thirteenthDish = new Dish("Eggplant Parmesan", "Sliced and breaded eggplant, layered with marinara sauce and mozzarella cheese, then baked to perfection.", 12.99);
           Dish fourteenthDish = new Dish("Lobster Bisque", "A rich and creamy soup made from lobster, cream, and a blend of spices, garnished with fresh herbs.", 16.99);
           Dish fifteenthDish = new Dish("Tandoori Salmon", "Salmon fillet marinated in tandoori spices and roasted in a tandoor or oven, served with naan or rice.", 17.99);

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