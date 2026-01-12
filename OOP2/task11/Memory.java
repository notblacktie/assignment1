package assignment2.OOP2.task11;

public class Memory {
    public static void executeDefragmentation(String[] array) {
        int write = 0;
        for (int read = 0; read < array.length; read++) {
            if (array[read] != null) {
                array[write++] = array[read];
            }
        }
        while (write < array.length) {
            array[write++] = null;
        }
    }
}
