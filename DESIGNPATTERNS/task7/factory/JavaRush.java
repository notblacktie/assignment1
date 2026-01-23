package assignment3.DESIGNPATTERNS.task7.factory;

import assignment3.DESIGNPATTERNS.task7.developers.Developer;
import assignment3.DESIGNPATTERNS.task7.developers.JavaDeveloper;

public class JavaRush extends ProgrammingCourse {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
