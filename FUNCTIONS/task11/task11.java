package assignment2.FUNCTIONS.task11;

public class task11 {
    public static void main(String[] args) {
        int[] array = {15, 64, 9, 51, 42};
        printSqrt(array);
    }

    public static void printSqrt(int[] array) {
        String prefix = "The square root of the number ";
        for (int element : array) {
            double sqrt = Math.sqrt(element);
            System.out.println(prefix + element + " is " + sqrt);
        }
    }
}

