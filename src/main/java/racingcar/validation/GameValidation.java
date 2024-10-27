package racingcar.validation;

import static racingcar.message.ExceptionMessage.CAR_NAME_DUPLICATE;
import static racingcar.message.ExceptionMessage.CAR_NAME_EMPTY;
import static racingcar.message.ExceptionMessage.CAR_NAME_TOO_LONG;
import static racingcar.message.ExceptionMessage.INVALID_ROUND;
import static racingcar.message.ExceptionMessage.NOT_A_NUMBER;
import static racingcar.message.ExceptionMessage.NOT_EXCEED_MINIMUM_AMOUNT;
import static racingcar.message.ExceptionMessage.NUMBER_PARSE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameValidation {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MIN_CAR_PLAYER = 2;
    private static final int MIN_TRY_COUNT = 1;

    public static void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            validateCarNameNotEmpty(carName);
            validateCarNameLength(carName);
            validateCarNameUniqueness(uniqueCarNames, carName);
        }
        validateMinimumCarCount(uniqueCarNames);
    }

    public static void validateTryCount(String input) {
        validateTryCountIsNumber(input);
        validateTryCountParse(input);
        validateTryCountRound(input);
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
        if (carName.isEmpty() || carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    private static void validateMinimumCarCount(Set<String> uniqueCarNames) {
        if (uniqueCarNames.size() < MIN_CAR_PLAYER) {
            throw new IllegalArgumentException(NOT_EXCEED_MINIMUM_AMOUNT.getMessage());
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

    private static void validateTryCountRound(String input) {
        int num = Integer.parseInt(input);
        if (num < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(INVALID_ROUND.getMessage());
        }
    }
}
