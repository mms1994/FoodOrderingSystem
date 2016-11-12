package main.model.dish;

public class DrinkBuilder {
    private Boolean iceCubes = false;
    private Boolean lemon = false;
    private String name;
    private Double price;

    public DrinkBuilder setIceCubes(Boolean iceCubes) {
        this.iceCubes = iceCubes;
        return this;
    }

    public DrinkBuilder setLemon(Boolean lemon) {
        this.lemon = lemon;
        return this;
    }

    public DrinkBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DrinkBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Drink createDrink() {
        return new Drink(iceCubes, lemon, name, price);
    }
}