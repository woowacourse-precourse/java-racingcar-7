package racingcar.racing.utils;

import static racingcar.racing.utils.ExceptionMessages.EMPTY_CAR_EXCEPTION_MESSAGE;
import static racingcar.racing.utils.ExceptionMessages.INPUT_EMPTY_EXCEPTION_MESSAGE;
import static racingcar.racing.utils.ExceptionMessages.INVALID_ATTEMPT_EXCEPTION_MESSAGE;
import static racingcar.racing.utils.ExceptionMessages.INVALID_CAR_LENGTH_EXCEPTION_MESSAGE;

import java.util.List;

public class InputValidator {
    public static boolean isAttemptNumberValid(int attemptNumber) {
        if (attemptNumber <= 0) {
            return false;
        }
        return true;
    }

    public static void validateAttemptNumber(int attemptNumber) {
        if (!isAttemptNumberValid(attemptNumber)) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_EXCEPTION_MESSAGE);
        }
    }

    public static boolean isInputNotEmptyValid(String inputCar) {
        if (inputCar == null || inputCar == "\n" || inputCar == "") {
            return false;
        }
        return true;
    }

    public static void validateInputNotEmpty(String input) {
        if (!isInputNotEmptyValid(input)) {
            throw new IllegalArgumentException(INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    public static boolean isCarNameLengthValid(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static void validateCarNameLength(List<String> carNames) {
        if (!InputValidator.isCarNameLengthValid(carNames)) {
            throw new IllegalArgumentException(INVALID_CAR_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public static boolean idCarArrayNotEmptyValid(List<String> carNames) {
        if (carNames.isEmpty() || carNames == null) {
            return false;
        }
        return true;
    }

    public static void validateCarArrayNotEmpty(List<String> carNames) {
        if (!idCarArrayNotEmptyValid(carNames)) {
            throw new IllegalArgumentException(EMPTY_CAR_EXCEPTION_MESSAGE);
        }
    }
}
