package assignment2.OOP2.task9;

import java.util.Objects;

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;      // same object
        if (obj == null) return false;     // null passed
        if (getClass() != obj.getClass()) return false; // not an Iphone

        Iphone other = (Iphone) obj;
        return price == other.price
                && Objects.equals(model, other.model)
                && Objects.equals(color, other.color);
    }
}
