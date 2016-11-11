package main.model.dish.meal;

/**
 * Created by Michał Spirała
 */
public class Pizza extends Meal {
    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
