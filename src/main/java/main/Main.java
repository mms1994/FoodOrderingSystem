package main;

import main.model.cuisine.Cuisine;
import main.model.dataloader.LoadCuisines;
import main.model.dataloader.LoadDrinks;
import main.model.dish.Drink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Michał Spirała
 */
public class Main {
    private final static LoadCuisines LOAD_CUISINES = new LoadCuisines();
    private final static LoadDrinks LOAD_DRINKS = new LoadDrinks();

    public static void main(String[] args) {
        Boolean finished = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!finished) {
                System.out.println("What do you want to order?");
                System.out.println("1: Lunch");
                System.out.println("2: Drink");
                System.out.println("3: Finish");
                String orderType = br.readLine();
                if (orderType.equals("1")) {
                    lunch();
                } else if (orderType.equals("2")) {
                    drink();
                } else if (orderType.equals("3")) {
                    finished = true;
                } else {
                    System.out.println("Type 1, 2 or 3 only");
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR!");
        }
    }

    private static void lunch() {
        List<Cuisine> cuisines = LOAD_CUISINES.load();

        System.out.println("Cuisines");
        cuisines.forEach(cuisine -> {
            System.out.println(cuisine.getName() + " meals");
            cuisine.getMeals().forEach(meal -> {
                System.out.println(meal.getName() + ": " + meal.getPrice() + "$");
            });
            System.out.println(cuisine.getName() + " desserts");
            cuisine.getDesserts().forEach(dessert -> {
                System.out.println(dessert.getName() + ": " + dessert.getPrice() + "$");
            });
            System.out.println("");
        });
    }

    private static void drink() {
        List<Drink> drinks = LOAD_DRINKS.load();

        System.out.println("Drinks");
        drinks.forEach(drink -> {
            System.out.println(drink.getName() + ": " + drink.getPrice() + "$");
        });
    }
}
