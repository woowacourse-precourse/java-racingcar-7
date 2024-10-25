package racingcar.racing.controller;

import java.util.List;

public class InputValidator {
    public static boolean validateAttemptNumber(int attemptNumber) {
        if (attemptNumber <= 0) {
            return false;
        }
        return true;
    }

    public static boolean validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
