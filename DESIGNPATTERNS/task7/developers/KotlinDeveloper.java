package assignment3.DESIGNPATTERNS.task7.developers;

public class KotlinDeveloper extends JavaDeveloper {
    @Override
    public void study() {
        super.study();
        System.out.println("Learning kotlin features...");
        writeCode();
    }
}
