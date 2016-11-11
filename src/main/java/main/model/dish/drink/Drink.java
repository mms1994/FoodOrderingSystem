package main.model.dish.drink;

import main.model.dish.Dish;

/**
 * Created by Michał Spirała
 */
public abstract class Drink extends Dish {
    protected Boolean iceCubes;
    protected Boolean lemon;

    public abstract Boolean getIceCubes();

    public abstract Boolean getLemon();
}
