package domain;

public class Course implements Identifiable {
    private int id;
    private String title;
    private String schedule;
    private Teacher teacher;

    public Course(int id, String title, String schedule, Teacher teacher) {
        this.id = id;
        this.title = title;
        this.schedule = schedule;
        this.teacher = teacher;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
