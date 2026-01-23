package assignment3.DESIGNPATTERNS.task4.move;

public class Fly implements MoveLogic {
    @Override
    public void move(String name) {
        System.out.println(name + " flapping its wings.");
    }
}
