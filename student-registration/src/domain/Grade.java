package domain;

public class Grade implements Identifiable {
    private int id;
    private String assessmentName;
    private double points;
    private double maxPoints;

    public Grade(int id, String assessmentName, double points, double maxPoints) {
        this.id = id;
        this.assessmentName = assessmentName;
        this.points = points;
        this.maxPoints = maxPoints;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(double maxPoints) {
        this.maxPoints = maxPoints;
    }
}
