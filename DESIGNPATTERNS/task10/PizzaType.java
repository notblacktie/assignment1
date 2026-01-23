package assignment3.DESIGNPATTERNS.task10;

public enum PizzaType {
    HAWAIIAN("Hawaiian pizza"),
    SPICY("Spicy pizza");

    private final String title;

    PizzaType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
