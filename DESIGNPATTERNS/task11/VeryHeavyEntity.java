package assignment3.DESIGNPATTERNS.task11;

import java.util.concurrent.TimeUnit;

public class VeryHeavyEntity implements Entity {
    private final int id;

    private VeryHeavyEntity(int id) {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.id = id;
    }

    public static VeryHeavyEntity load(int id) {
        System.out.println("Data is being initialized... This may take a few minutes...");
        VeryHeavyEntity entity = new VeryHeavyEntity(id);
        System.out.println("Data initialization completed!");
        return entity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String find(String query) {
        return "Nothing found.";
    }
}
