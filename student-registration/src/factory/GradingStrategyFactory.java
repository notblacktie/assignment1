package factory;

import strategy.GradingStrategy;
import strategy.LetterGradingStrategy;
import strategy.PassFailGradingStrategy;

public class GradingStrategyFactory {
    public GradingStrategy create(String mode) {
        if ("PASS_FAIL".equalsIgnoreCase(mode)) {
            return new PassFailGradingStrategy();
        }
        return new LetterGradingStrategy();
    }
}
