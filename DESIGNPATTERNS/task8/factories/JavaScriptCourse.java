package assignment3.DESIGNPATTERNS.task8.factories;

import assignment3.DESIGNPATTERNS.task8.juniors.JavaScriptJunior;
import assignment3.DESIGNPATTERNS.task8.juniors.JuniorDeveloper;
import assignment3.DESIGNPATTERNS.task8.middle.JavaScriptMiddle;
import assignment3.DESIGNPATTERNS.task8.middle.MiddleDeveloper;
import assignment3.DESIGNPATTERNS.task8.seniors.JavaScriptSenior;
import assignment3.DESIGNPATTERNS.task8.seniors.SeniorDeveloper;

public class JavaScriptCourse implements DeveloperCourse {
    @Override
    public JuniorDeveloper createJunior() {
        return new JavaScriptJunior();
    }

    @Override
    public MiddleDeveloper createMiddle() {
        return new JavaScriptMiddle();
    }

    @Override
    public SeniorDeveloper createSenior() {
        return new JavaScriptSenior();
    }
}
