package assignment3.DESIGNPATTERNS.task7.developers;

public class DotNetDeveloper implements Developer {
    @Override
    public void study() {
        writeCode();
    }

    @Override
    public void writeCode() {
        System.out.println("Шлепает формы...");
    }
}
