package assignment2.OOP2.task5;

public class Task5 {
    public static void main(String[] args) {
        Building building = new Building();

        building.initialize("Restaurant");
        System.out.println(building.getType());

        building.initialize("Barbershop");
        System.out.println(building.getType());
    }
}
