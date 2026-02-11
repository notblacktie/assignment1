package assignment2.oop1;

public class task4 {
    public static class Entity {
        public void move() {
            System.out.println("I'm moving.");
        }

        public void eat() {
            System.out.println("I'm eating.");
        }
    }

    public static class Human extends Entity {
        public void speak() {
            System.out.println("I can communicate.");
        }
    }

    public static class JavaDeveloper extends Human {
        public void code() {
            System.out.println("I know how to communicate in Java.");
        }
    }

    public static void main(String[] args) {  }
}

