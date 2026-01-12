package assignment2.OOP2.task11;

import java.util.Arrays;

public class Task11 {
    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, "object32", null, "object4"};
        Memory.executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }
}
