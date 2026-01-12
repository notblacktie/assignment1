package assignment2.OOP2.task16;

public class Task16 {
    public static void main(String[] args) {
        Car car = new Car();
        car.initialize("Lamborghini", 2023, "Black");

        System.out.println(car.getModel());
        System.out.println(car.getYear());
        System.out.println(car.getColor());
    }
}
