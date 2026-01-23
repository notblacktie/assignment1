package assignment3.DESIGNPATTERNS.task2;

public class WithChicken extends PizzaDecorator {

    public WithChicken(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", chicken";
    }
}
