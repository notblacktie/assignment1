package assignment3.DESIGNPATTERNS.task6;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class Universe {

    private static Universe instance;

    private final Set<String> laws = new HashSet<>();

    private Universe() {
        System.out.println("Fine-tuning the immutable laws of the universe begins...");
        tune("speed of light");
        tune("gravitational constant");
        tune("Planck constant");
        tune("electron mass");
        tune("proton mass");
        tune("electron charge");
        System.out.println("Fine-tuning the immutable laws of the universe is over.");
    }

    public static Universe getInstance() {
        if (instance == null) {
            instance = new Universe();
        }
        return instance;
    }

    public Set<String> getLaws() {
        return Collections.unmodifiableSet(laws);
    }

    private void tune(String low) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("устанавливается " + low);
        laws.add(low);
    }
}
