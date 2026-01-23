package assignment3.DESIGNPATTERNS.task7.factory;

import assignment3.DESIGNPATTERNS.task7.developers.Developer;
import assignment3.DESIGNPATTERNS.task7.developers.DotNetDeveloper;

public class DotNetCourse extends ProgrammingCourse {
    @Override
    public Developer createDeveloper() {
        return new DotNetDeveloper();
    }
}
