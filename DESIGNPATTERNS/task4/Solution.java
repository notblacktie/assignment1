package assignment3.DESIGNPATTERNS.task4;

import assignment3.DESIGNPATTERNS.task4.creature.Cow;
import assignment3.DESIGNPATTERNS.task4.move.Fly;
import assignment3.DESIGNPATTERNS.task4.sound.Meow;


public class Solution {
    public static void main(String[] args) {

        Cow cow = new Cow(new Fly(), new Meow());
        cow.howDoIMove();
        cow.howDoISound();
        cow.giveMilk();
    }
}
