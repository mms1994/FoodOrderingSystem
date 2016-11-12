package main.model.cuisine;

import main.model.dish.Dessert;
import main.model.dish.Meal;

import java.util.List;

/**
 * Created by Michał Spirała
 */
public class Cuisine {
    private final List<Meal> meals;
    private final List<Dessert> desserts;
    private final String name;


    public Cuisine(List<Meal> meals, List<Dessert> desserts, String name) {
        this.meals = meals;
        this.desserts = desserts;
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public String getName() {
        return name;
    }
}
