package assignment3.DESIGNPATTERNS.task1;

public class MicroscopeAdapter extends Hammer {
    private final Microscope microscope;

    public MicroscopeAdapter(Microscope microscope) {
        this.microscope = microscope;
    }

    @Override
    public boolean hit(Nail nail) {
        microscope.bang();
        return false;
    }
}
