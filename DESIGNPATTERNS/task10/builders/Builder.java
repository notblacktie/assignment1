package assignment3.DESIGNPATTERNS.task10.builders;

import assignment3.DESIGNPATTERNS.task10.PizzaType;

public interface Builder {
    void setType(PizzaType type);
    void setDough(String dough);
    void setSauce(String sauce);
    void setTopping(String topping);
}
