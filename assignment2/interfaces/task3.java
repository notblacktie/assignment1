package assignment2.interfaces;


public class task3 {
    public static void main(String[] args) {
    }

    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public class Human implements CanRun, CanSwim {
        public void run() {}
        public void swim() {}
    }

    public class Duck implements CanFly, CanSwim, CanRun {
        public void fly() {}
        public void swim() {}
        public void run() {}
    }

    public class Penguin implements CanSwim, CanRun {
        public void swim() {}
        public void run() {}
    }

    public class Airplane implements CanFly {
        public void fly() {}
    }
}
