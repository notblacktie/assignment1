package assignment2.oop2;
//task9
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
        if (this == obj) return true;
        if (!(obj instanceof Iphone)) return false;
        Iphone other = (Iphone) obj;
        return price == other.price
                && Objects.equals(model, other.model)
                && Objects.equals(color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, price);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);
        System.out.println(iphone1.equals(iphone2));
    }
}

