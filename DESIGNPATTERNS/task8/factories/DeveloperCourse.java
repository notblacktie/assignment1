package assignment3.DESIGNPATTERNS.task8.factories;

import assignment3.DESIGNPATTERNS.task8.juniors.JuniorDeveloper;
import assignment3.DESIGNPATTERNS.task8.middle.MiddleDeveloper;
import assignment3.DESIGNPATTERNS.task8.seniors.SeniorDeveloper;

public interface DeveloperCourse {
    JuniorDeveloper createJunior();
    MiddleDeveloper createMiddle();
    SeniorDeveloper createSenior();
}
