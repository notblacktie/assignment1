package assignment3.DESIGNPATTERNS.task8.factories;

import assignment3.DESIGNPATTERNS.task8.juniors.JavaJunior;
import assignment3.DESIGNPATTERNS.task8.juniors.JuniorDeveloper;
import assignment3.DESIGNPATTERNS.task8.middle.JavaMiddle;
import assignment3.DESIGNPATTERNS.task8.middle.MiddleDeveloper;
import assignment3.DESIGNPATTERNS.task8.seniors.JavaSenior;
import assignment3.DESIGNPATTERNS.task8.seniors.SeniorDeveloper;

public class JavaRush implements DeveloperCourse {
    @Override
    public JuniorDeveloper createJunior() {
        return new JavaJunior();
    }

    @Override
    public MiddleDeveloper createMiddle() {
        return new JavaMiddle();
    }

    @Override
    public SeniorDeveloper createSenior() {
        return new JavaSenior();
    }
}
