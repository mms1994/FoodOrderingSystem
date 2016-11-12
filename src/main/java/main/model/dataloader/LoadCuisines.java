package main.model.dataloader;

import main.model.cuisine.Cuisine;
import main.model.dish.Dessert;
import main.model.dish.DessertBuilder;
import main.model.dish.Meal;
import main.model.dish.MealBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michał Spirała
 */
public class LoadCuisines {
    public List<Cuisine> load() {
        List<Cuisine> cuisines = new LinkedList<>();
//        polish cuisine
        cuisines.add(loadPolish());
//        mecixan cuisine
        cuisines.add(loadMexican());
//        italian cuisine
        cuisines.add(loadItalian());
        return cuisines;
    }

    private Cuisine loadItalian() {
        List<Meal> meals = new LinkedList<>();
        List<Dessert> desserts = new LinkedList<>();
        String name = "Italian";
        meals.add(new MealBuilder().setName("Spaghetti").setPrice(15.0).createMeal());
        meals.add(new MealBuilder().setName("Pizza").setPrice(16.0).createMeal());
        desserts.add(new DessertBuilder().setName("Tozzetti").setPrice(5.0).createDessert());
        desserts.add(new DessertBuilder().setName("Tiramisu").setPrice(6.0).createDessert());
        return new Cuisine(meals, desserts, name);
    }

    private Cuisine loadMexican() {
        List<Meal> meals = new LinkedList<>();
        List<Dessert> desserts = new LinkedList<>();
        String name = "Mexican";
        meals.add(new MealBuilder().setName("Chili Con Carne").setPrice(15.0).createMeal());
        meals.add(new MealBuilder().setName("Carnitas").setPrice(16.0).createMeal());
        desserts.add(new DessertBuilder().setName("Pan De Muerto").setPrice(6.0).createDessert());
        desserts.add(new DessertBuilder().setName("Churros with chocolate").setPrice(8.0).createDessert());
        return new Cuisine(meals, desserts, name);
    }

    private Cuisine loadPolish() {
        List<Meal> meals = new LinkedList<>();
        List<Dessert> desserts = new LinkedList<>();
        String name = "Polish";
        meals.add(new MealBuilder().setName("Bigos").setPrice(15.0).createMeal());
        meals.add(new MealBuilder().setName("Schabowy").setPrice(16.0).createMeal());
        desserts.add(new DessertBuilder().setName("Sernik").setPrice(6.0).createDessert());
        desserts.add(new DessertBuilder().setName("Szarlotka").setPrice(7.0).createDessert());
        return new Cuisine(meals, desserts, name);
    }
}
