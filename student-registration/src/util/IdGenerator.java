package util;

public class IdGenerator {
    private int current;

    public IdGenerator() {
        this.current = 0;
    }

    public int nextId() {
        current++;
        return current;
    }
}
