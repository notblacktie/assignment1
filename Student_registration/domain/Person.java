package assignment4.Student_registration.domain;

public abstract class Person {
    private int id;
    private String fullName;
    private String email;

    public Person(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + fullName + " | Email: " + email;
    }
}
