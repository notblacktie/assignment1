package assignment3.DESIGNPATTERNS.task6;


public class Solution {

    public static void main(String[] args) {
        Universe universe = Universe.getInstance();
        Universe anotherUniverse = Universe.getInstance();

        System.out.println(universe);
        System.out.println(anotherUniverse);
    }
}
