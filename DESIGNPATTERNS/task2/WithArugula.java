package assignment3.DESIGNPATTERNS.task2;

public class WithArugula extends PizzaDecorator {

    public WithArugula(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", arugula";
    }
}
