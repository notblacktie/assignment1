package assignment3.DESIGNPATTERNS.task8.factories;

import assignment3.DESIGNPATTERNS.task8.juniors.JuniorDeveloper;
import assignment3.DESIGNPATTERNS.task8.juniors.PythonJunior;
import assignment3.DESIGNPATTERNS.task8.middle.MiddleDeveloper;
import assignment3.DESIGNPATTERNS.task8.middle.PythonMiddle;
import assignment3.DESIGNPATTERNS.task8.seniors.PythonSenior;
import assignment3.DESIGNPATTERNS.task8.seniors.SeniorDeveloper;

public class PythonCourse implements DeveloperCourse {
    @Override
    public JuniorDeveloper createJunior() {
        return new PythonJunior();
    }

    @Override
    public MiddleDeveloper createMiddle() {
        return new PythonMiddle();
    }

    @Override
    public SeniorDeveloper createSenior() {
        return new PythonSenior();
    }
}
