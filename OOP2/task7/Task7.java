package assignment2.OOP2.task7;

public class Task7 {
    public static void main(String[] args) {
        Programmer p = new Programmer();

        System.out.println(p.getSalary()); // 1000

        p.setSalary(900);
        System.out.println(p.getSalary()); // still 1000 (not increased)

        p.setSalary(1500);
        System.out.println(p.getSalary()); // 1500
    }
}
