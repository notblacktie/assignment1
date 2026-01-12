package assignment2.INTERFACES.task5;

public class BeerLover implements Alcoholic {

    @Override
    public void askForMore(String message) {}

    @Override
    public void sayThankYou() {}

    @Override
    public boolean isReadyToGoHome() {
        return READY_TO_GO_HOME;
    }

    @Override
    public void sleepOnTheFloor() {}
}
