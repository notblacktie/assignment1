package assignment2.INTERFACES.task10;

public class Manager implements Boss {

    @Override
    public void use(Person person) {
        person.startToWork();
    }

    @Override
    public void startToWork() {
    }

    @Override
    public boolean inspiresOthersToWork() {
        return true;
    }
}
