package assignment3.DESIGNPATTERNS.task2;

public class SimplePizza implements Pizza {
    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public String getIngredients() {
        return "dough, tomatoes, cheese";
    }
}
