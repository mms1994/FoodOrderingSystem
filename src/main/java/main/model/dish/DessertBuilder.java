package main.model.dish;

public class DessertBuilder {
    private Double price;
    private String name;

    public DessertBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public DessertBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Dessert createDessert() {
        return new Dessert(price, name);
    }
}