package assignment3.DESIGNPATTERNS.task4.creature;

import assignment3.DESIGNPATTERNS.task4.move.MoveLogic;
import assignment3.DESIGNPATTERNS.task4.sound.SoundLogic;

public class Cow extends Creature {
    public Cow(MoveLogic moveLogic, SoundLogic soundLogic) {
        super(moveLogic, soundLogic);
    }

    @Override
    public String getName() {
        return "Cow";
    }

    public void giveMilk() {
        System.out.println(getName() + " gives milk.");
    }
}
