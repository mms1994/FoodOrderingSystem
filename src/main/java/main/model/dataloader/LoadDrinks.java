package main.model.dataloader;

import main.model.dish.Drink;
import main.model.dish.DrinkBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michał Spirała
 */
public class LoadDrinks {

    public List<Drink> load() {
        List<Drink> drinks = new LinkedList<>();
        drinks.add(new DrinkBuilder().setName("Tea").setPrice(5.0).createDrink());
        drinks.add(new DrinkBuilder().setName("Coffee").setPrice(5.0).createDrink());
        drinks.add(new DrinkBuilder().setName("Cola").setPrice(4.0).createDrink());
        drinks.add(new DrinkBuilder().setName("Nestea").setPrice(4.0).createDrink());
        return drinks;
    }
}
