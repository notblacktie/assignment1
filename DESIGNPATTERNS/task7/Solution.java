package assignment3.DESIGNPATTERNS.task7;

import assignment3.DESIGNPATTERNS.task7.factory.*;

public class Solution {

    private static ProgrammingCourse course;

    public static void main(String[] args) {
        choose("web");
        startLearningProcess();
    }

    static void choose(String direction) {
        if (direction.equals("web")) {
            course = new JavaRush();
        } else if (direction.equals("android")) {
            course = new KotlinCourse();
        } else {
            course = new DotNetCourse();
        }
    }

    static void startLearningProcess() {
        course.educateStudent();
    }
}
