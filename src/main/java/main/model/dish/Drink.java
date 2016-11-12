package main.model.dish;

/**
 * Created by Michał Spirała
 */
public class Drink extends Dish {
    protected Boolean iceCubes;
    protected Boolean lemon;

    public Drink(Boolean iceCubes, Boolean lemon, String name, Double price) {
        super(price, name);
        this.iceCubes = iceCubes;
        this.lemon = lemon;
    }

    public void setIceCubes(Boolean iceCubes) {
        this.iceCubes = iceCubes;
    }

    public void setLemon(Boolean lemon) {
        this.lemon = lemon;
    }

    public Boolean getIceCubes() {
        return iceCubes;
    }


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