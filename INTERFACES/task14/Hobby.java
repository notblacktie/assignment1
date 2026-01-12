package assignment2.INTERFACES.task14;

public class Hobby implements Desire, Dream {
    public static int INDEX = 1;

    @Override
    public String toString() {
        INDEX++;
        return "" + INDEX;
    }
}
