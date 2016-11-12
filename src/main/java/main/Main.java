package main;

import main.model.cuisine.Cuisine;
import main.model.dataloader.LoadCuisines;
import main.model.dataloader.LoadDrinks;
import main.model.dish.Dish;
import main.model.dish.Drink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
                System.out.println("What do you want to order? To exit type any thing else");
                System.out.println("1: Lunch");
                System.out.println("2: Drink");
                String orderType = br.readLine();
                switch (orderType) {
                    case "1":
                        lunch(br);
                        break;
                    case "2":
                        drink(br);
                        break;
                    default:
                        finished = true;
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR!");
        }
    }

    private static void lunch(BufferedReader br) throws IOException {
        List<Cuisine> cuisines = LOAD_CUISINES.load();
        List<Dish> order = new LinkedList<>();
        System.out.println("Select cuisine");
        System.out.println("Cuisines");
        cuisines.forEach(cuisine -> System.out.printf("%d: %s%n", cuisines.indexOf(cuisine), cuisine.getName()));
        String selectedCuisine = br.readLine();
        try {
            if (Integer.parseInt(selectedCuisine) >= cuisines.size())
                System.out.println("Input right number");
            else {
                Boolean finished = false;
                String input;
                Cuisine cuisine = cuisines.get(Integer.parseInt(selectedCuisine));
                while (!finished) {
                    System.out.println("Select main course");
                    cuisine.getMeals().forEach(meal -> System.out
                            .printf("%d: %s %s$%n", cuisine.getMeals().indexOf(meal), meal.getName(), meal.getPrice()));
                    System.out.println("To exit type 'e'");
                    input = br.readLine();
                    if (input.equals("e"))
                        finished = true;
                    else {
                        try {
                            if (Integer.parseInt(input) >= cuisine.getMeals().size())
                                System.out.println("Input right number");
                            else
                                order.add(cuisine.getMeals().get(Integer.parseInt(input)));
                        } catch (NumberFormatException e) {
                            System.out.println("Input right number");
                        }
                    }
                }
                finished = false;
                while (!finished) {
                    System.out.println("Select dessert");
                    cuisine.getDesserts().forEach(dessert -> System.out
                            .printf("%d: %s %s$%n", cuisine.getDesserts().indexOf(dessert), dessert.getName(), dessert
                                    .getPrice()));
                    System.out.println("To exit type 'e'");
                    input = br.readLine();
                    if (input.equals("e"))
                        finished = true;
                    else {
                        try {
                            if (Integer.parseInt(input) >= cuisine.getDesserts().size())
                                System.out.println("Input right number");
                            else
                                order.add(cuisine.getDesserts().get(Integer.parseInt(input)));
                        } catch (NumberFormatException e) {
                            System.out.println("Input right number");
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input right number");
        }
        System.out.println("Dishes ordered:");
        order.forEach(dish -> System.out.println(dish.getName()));
        final Double[] price = {0.0};
        order.forEach(dish -> price[0] += dish.getPrice());
        System.out.println("Total price: " + price[0]);
    }

    private static void drink(BufferedReader br) throws IOException {
        List<Drink> drinks = LOAD_DRINKS.load();
        List<Drink> order = new LinkedList<>();
        Boolean finished = false;
        while (!finished) {
            System.out.println("Select drink");
            System.out.println("Drinks");
            drinks.forEach(drink -> System.out
                    .printf("%d: %s %s$%n", drinks.indexOf(drink), drink.getName(), drink.getPrice()));
            System.out.println("To exit type 'e'");
            String input = br.readLine();
            if (input.equals("e"))
                finished = true;
            else {
                try {
                    if (Integer.parseInt(input) >= drinks.size())
                        System.out.println("Input right number");
                    else {
                        Drink drink = drinks.get(Integer.parseInt(input));
                        System.out.println("Type 1 if you want ice cubs or any thing else if not");
                        String iceCubs = br.readLine();
                        if (iceCubs.equals("1"))
                            drink.setIceCubes();
                        System.out.println("Type 1 if you want lemon or any thing else if not");
                        String lemon = br.readLine();
                        if (lemon.equals("1"))
                            drink.setLemon();
                        order.add(drink);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input right number");
                }
            }
        }
        System.out.println("Drinks ordered:");
        order.forEach(drink -> {
            String addons = "";
            if (drink.getIceCubes())
                addons += "+ice_cubs";
            if (drink.getLemon())
                addons += "+lemon";
            System.out.printf("%s%s%n", drink.getName(), addons);
        });
        final Double[] price = {0.0};
        order.forEach(drink -> price[0] += drink.getPrice());
        System.out.println("Total price: " + price[0]);
    }
}
