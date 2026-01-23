package assignment3.DESIGNPATTERNS.task7.developers;

public class JavaDeveloper implements Developer {
    @Override
    public void study() {
        System.out.println("Gaining computer literacy...");
        System.out.println("Learning English...");
        System.out.println("Learning Java...");
        writeCode();
        System.out.println("Learning patterns... ");
        writeCode();
        System.out.println("Learning best practices...");
        writeCode();
        System.out.println("Learning databases...");
        writeCode();
        System.out.println("Learning popular frameworks...");
        writeCode();
    }

    @Override
    public void writeCode() {
        System.out.println("Writes some code...");
    }
}
