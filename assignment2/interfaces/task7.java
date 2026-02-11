package assignment2.interfaces;


public class task7 {

    public static void main(String[] args) {
        System.out.println(Dream.HOBBY.toString());
        System.out.println(Dream.HOBBY.toString());
    }

    interface Desire {
    }

    interface Dream {
        Hobby HOBBY = new Hobby(); // public static final by default
    }

    static class Hobby implements Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }
}
