package main.model.dish;

public class MealBuilder {
    private String name;
    private Double price;

    public MealBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MealBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Meal createMeal() {
        return new Meal(name, price);
    }
}