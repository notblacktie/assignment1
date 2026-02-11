package assignment2.oop2;
//task11
import java.util.Arrays;

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

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }
}

