package assignment2.OOP2.task4;

public class Task4 {
    public static void main(String[] args) {
        CarConcern c1 = new CarConcern("Aventador", 2020, "Black");
        CarConcern c2 = new CarConcern("Huracan", 2022);
        CarConcern c3 = new CarConcern("Urus");

        System.out.println(c1.getManufacturer() + " " + c1.getModel() + " " + c1.getYear() + " " + c1.getColor());
        System.out.println(c2.getManufacturer() + " " + c2.getModel() + " " + c2.getYear() + " " + c2.getColor());
        System.out.println(c3.getManufacturer() + " " + c3.getModel() + " " + c3.getYear() + " " + c3.getColor());
    }
}
