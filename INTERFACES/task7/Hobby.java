package assignment2.INTERFACES.task7;

public class Hobby implements Desire, Dream {
    static int INDEX = 1;

    @Override
    public String toString() {
        INDEX++;
        return "" + INDEX;
    }
}
