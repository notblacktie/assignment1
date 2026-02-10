package strategy;

public class PassFailGradingStrategy implements GradingStrategy {
    @Override
    public String evaluate(double percentage) {
        return percentage >= 60 ? "PASS" : "FAIL";
    }
}
