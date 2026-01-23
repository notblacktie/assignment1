package assignment3.DESIGNPATTERNS.task4.sound;

public class Speak implements SoundLogic {
    @Override
    public void sound(String name) {
        System.out.println(name + " speaks.");
    }
}
