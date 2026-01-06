package assignment2.oop1;

public class task3 {
    public static class Vehicle {
        double maxSpeed;
        int wheelCount;
        double weight;
    }

    public static class Car extends Vehicle { }

    public static class ElectricCar extends Car {
        int electricEnginePower;
    }

    public static void main(String[] args) { }
}
