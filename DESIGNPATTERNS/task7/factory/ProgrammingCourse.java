package assignment3.DESIGNPATTERNS.task7.factory;

import assignment3.DESIGNPATTERNS.task7.developers.Developer;

public abstract class ProgrammingCourse {

    public abstract Developer createDeveloper();

    public void educateStudent() {
        Developer developer = createDeveloper();
        developer.study();
    }
}
