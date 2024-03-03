package com.example.activitiesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DessertsActivity extends AppCompatActivity {
    private ListView dessertsList;
    private ArrayList<Dish> dishList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        initialiseDishes();
        dessertsList =  findViewById(R.id.list_view_desserts);

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1, this.dishList);

        this.dessertsList.setAdapter(dishesAdapter);
    }

    private void initialiseDishes() {
        Dish firstDessert = new Dish("Tiramisu", "Classic Italian dessert made with layers of coffee-soaked ladyfingers and mascarpone cheese.", 6.99);
        Dish secondDessert = new Dish("Chocolate Mousse", "A rich and velvety chocolate dessert topped with whipped cream.", 7.99);
        Dish thirdDessert = new Dish("New York Cheesecake", "Creamy cheesecake with a graham cracker crust, topped with fruit or caramel sauce.", 8.99);
        Dish fourthDessert = new Dish("Fruit Sorbet", "Refreshing fruit sorbet with a variety of fruity flavors.", 5.99);
        Dish fifthDessert = new Dish("Molten Lava Cake", "Warm and gooey chocolate cake with a melting center, served with vanilla ice cream.", 9.99);
        Dish sixthDessert = new Dish("Panna Cotta", "Italian dessert made with sweetened cream and topped with a fruit compote or caramel sauce.", 7.99);
        Dish seventhDessert = new Dish("Fruit Tart", "Tart with a flaky pastry crust filled with pastry cream and topped with fresh fruit.", 8.99);
        Dish eighthDessert = new Dish("Creme Brulee", "Classic dessert with a rich and creamy custard topped with a caramelized sugar crust.", 9.99);
        Dish ninthDessert = new Dish("Chocolate Fondue", "A delightful dessert featuring a pot of melted chocolate for dipping fruits, marshmallows, and cake pieces.", 10.99);
        Dish tenthDessert = new Dish("Red Velvet Cake", "Moist and fluffy red velvet cake with cream cheese frosting.", 7.99);
        Dish eleventhDessert = new Dish("Fudge Brownie Sundae", "Warm fudge brownie topped with vanilla ice cream, hot fudge sauce, and whipped cream.", 8.99);
        Dish twelfthDessert = new Dish("Fruit Parfait", "Layered dessert with yogurt, granola, and a variety of fresh fruits.", 6.99);
        Dish thirteenthDessert = new Dish("Chocolate Chip Cookies", "Homemade chocolate chip cookies served warm with a glass of milk.", 5.99);
        Dish fourteenthDessert = new Dish("Strawberry Shortcake", "Classic dessert with layers of sponge cake, fresh strawberries, and whipped cream.", 7.99);
        Dish fifteenthDessert = new Dish("Banana Split", "Ice cream dessert with bananas, hot fudge, caramel, whipped cream, and nuts.", 9.99);

        dishList.add(firstDessert);
        dishList.add(secondDessert);
        dishList.add(thirdDessert);
        dishList.add(fourthDessert);
        dishList.add(fifthDessert);
        dishList.add(sixthDessert);
        dishList.add(seventhDessert);
        dishList.add(eighthDessert);
        dishList.add(ninthDessert);
        dishList.add(tenthDessert);
        dishList.add(eleventhDessert);
        dishList.add(twelfthDessert);
        dishList.add(thirteenthDessert);
        dishList.add(fourteenthDessert);
        dishList.add(fifteenthDessert);
    }

}