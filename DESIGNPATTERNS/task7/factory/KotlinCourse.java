package assignment3.DESIGNPATTERNS.task7.factory;

import assignment3.DESIGNPATTERNS.task7.developers.Developer;
import assignment3.DESIGNPATTERNS.task7.developers.KotlinDeveloper;

public class KotlinCourse extends ProgrammingCourse {
    @Override
    public Developer createDeveloper() {
        return new KotlinDeveloper();
    }
}
