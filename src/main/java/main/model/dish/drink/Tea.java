package main.model.dish.drink;

/**
 * Created by Michał Spirała
 */
public class Tea extends Drink {
    @Override
    public Boolean getIceCubes() {
        return iceCubes;
    }

    @Override
    public Boolean getLemon() {
        return lemon;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
