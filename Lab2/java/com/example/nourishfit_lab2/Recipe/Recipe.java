package com.example.nourishfit_lab2.Recipe;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_recipe")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private int image;
    private String creator;
    private String instructions;


    public Recipe(String name ,String description ,String instructions,  int image, String creator ){
        this.name=name;
        this.description=description;
        this.instructions = instructions;
        this.image=image;
        this.creator = creator ;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCreator() {
        return creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
