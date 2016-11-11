package main.model.dish;

/**
 * Created by Michał Spirała
 */
public abstract class Dish {
    protected Double price;
    protected String name;

    public abstract Double getPrice();

    public abstract String getName();
}
