package racingcar.racing.utils;

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

    public static boolean validateCarArrayNotEmpty(List<String> carNames) {
        if (carNames.isEmpty() || carNames == null) {
            return false;
        }
        return true;
    }

    public static boolean validateInputNotEmpty(String inputCar) {
        if (inputCar == null || inputCar == "\n" || inputCar == "") {
            return false;
        }
        return true;
    }
}
