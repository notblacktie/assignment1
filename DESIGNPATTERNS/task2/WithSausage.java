package assignment3.DESIGNPATTERNS.task2;

public class WithSausage extends PizzaDecorator {

    public WithSausage(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 25;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", sausage";
    }
}
