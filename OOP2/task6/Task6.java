package assignment2.OOP2.task6;

public class Task6 {
    public static void main(String[] args) {
        Bugatti car = new Bugatti();

        System.out.println(car.getBody()); // Coupe
        car.setBody("Roadster");
        System.out.println(car.getBody()); // Roadster
    }
}
