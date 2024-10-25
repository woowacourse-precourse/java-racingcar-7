package racingcar.util;

import static racingcar.enums.ExceptionMessage.ATTEMPTS_LESS_THAN_ONE;
import static racingcar.enums.ExceptionMessage.DUPLICATE_CAR_NAMES;
import static racingcar.enums.ExceptionMessage.EMPTY_CAR_NAME;
import static racingcar.enums.ExceptionMessage.EMPTY_CAR_NAMES;
import static racingcar.enums.ExceptionMessage.INVALID_ATTEMPTS_NUMBER;
import static racingcar.enums.ExceptionMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.enums.ExceptionMessage.SINGLE_CAR_NAME;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAMES.getMessage());
        }

        String[] namesArray = carNames.split(",", -1);
        if (namesArray.length == 1) {
            throw new IllegalArgumentException(SINGLE_CAR_NAME.getMessage());
        }

        Arrays.stream(namesArray).forEach(Validator::validateCarName);

        Set<String> uniqueNames = new HashSet<>(Arrays.asList(namesArray));
        if (uniqueNames.size() != namesArray.length) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES.getMessage());
        }
    }

    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
        }
    }

    public static void validateAttempts(String attempts) {
        try {
            int attemptCount = Integer.parseInt(attempts);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException(ATTEMPTS_LESS_THAN_ONE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ATTEMPTS_NUMBER.getMessage());
        }
    }
}
