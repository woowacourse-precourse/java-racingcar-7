package racingcar.validation;

import static racingcar.message.ExceptionMessage.CAR_NAME_DUPLICATE;
import static racingcar.message.ExceptionMessage.CAR_NAME_EMPTY;
import static racingcar.message.ExceptionMessage.CAR_NAME_TOO_LONG;
import static racingcar.message.ExceptionMessage.NOT_A_NUMBER;
import static racingcar.message.ExceptionMessage.NUMBER_PARSE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameValidation {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            validateCarNameNotEmpty(carName);
            validateCarNameLength(carName);
            validateCarNameUniqueness(uniqueCarNames, carName);
        }
    }

    public static void validateTryCount(String input) {
        validateTryCountIsNumber(input);
        validateTryCountParse(input);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }

    private static void validateCarNameUniqueness(Set<String> uniqueCarNames, String carName) {
        if (!uniqueCarNames.add(carName)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private static void validateCarNameNotEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    private static void validateTryCountIsNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }

    private static void validateTryCountParse(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSE_ERROR.getMessage());
        }
    }
}
