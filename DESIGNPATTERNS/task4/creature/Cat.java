package assignment3.DESIGNPATTERNS.task4.creature;

import assignment3.DESIGNPATTERNS.task4.move.MoveLogic;
import assignment3.DESIGNPATTERNS.task4.sound.SoundLogic;

public class Cat extends Creature {
    public Cat(MoveLogic moveLogic, SoundLogic soundLogic) {
        super(moveLogic, soundLogic);
    }

    @Override
    public String getName() {
        return "Cat";
    }

    public void catchMice() {
        System.out.println(getName() + " catches mice.");
    }
}
