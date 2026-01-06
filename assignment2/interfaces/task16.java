package assignment2.interfaces;


import java.awt.Color;

public class task16 {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
        Integer getAge();
    }

    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox.";
        }
    }
}
