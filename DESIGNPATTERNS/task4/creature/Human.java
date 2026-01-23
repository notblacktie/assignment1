package assignment3.DESIGNPATTERNS.task4.creature;

import assignment3.DESIGNPATTERNS.task4.move.MoveLogic;
import assignment3.DESIGNPATTERNS.task4.sound.SoundLogic;

public class Human extends Creature {
    public Human(MoveLogic moveLogic, SoundLogic soundLogic) {
        super(moveLogic, soundLogic);
    }

    @Override
    public String getName() {
        return "Person";
    }

    public void searchMeaningOfLife() {
        System.out.println(getName() + " looking for the meaning of life.");
    }
}
