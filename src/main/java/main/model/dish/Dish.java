package main.model.dish;

/**
 * Created by Michał Spirała
 */
public abstract class Dish {
    protected final Double price;
    protected final String name;

    protected Dish(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    public abstract Double getPrice();

    public abstract String getName();
}
