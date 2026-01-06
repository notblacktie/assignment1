package assignment2.interfaces;

public class Person implements RepkaItem {
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getNamePadezh() {
        return namePadezh;
    }

    public void pull(Person person) {
        System.out.println(this.name + " for " + person.getNamePadezh());
    }
}
