package assignment2.OOP2.task16;

public class Car {
    private String model;
    private int year;
    private String color;

    public void initialize(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // optional getters (for testing)
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
}
