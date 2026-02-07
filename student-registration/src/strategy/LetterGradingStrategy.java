package strategy;

public class LetterGradingStrategy implements GradingStrategy {
    @Override
    public String evaluate(double percentage) {
        if (percentage >= 90) {
            return "A";
        }
        if (percentage >= 80) {
            return "B";
        }
        if (percentage >= 70) {
            return "C";
        }
        if (percentage >= 60) {
            return "D";
        }
        return "F";
    }
}
