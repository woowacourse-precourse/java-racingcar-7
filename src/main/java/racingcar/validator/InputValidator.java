package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingException;

import java.util.List;

public class InputValidator {

    private static final int MINIMUM_CAR_COUNT = 2;

    public static void validateEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw RacingException.of(ErrorMessage.EMPTY_INPUT);
        }
    }

    public static void validateDuplicate(final List<String> names) {
        validateMinimumCarCount(names);
        if (isDuplicated(names)) {
            throw RacingException.of(ErrorMessage.DUPLICATE_CAR_NAME);
        }
    }

    private static boolean isDuplicated(final List<String> names) {
        return names.size() != names.stream()
                .distinct()
                .count();
    }

    private static void validateMinimumCarCount(final List<String> names) {
        if (names.size() < MINIMUM_CAR_COUNT) {
            throw RacingException.of(ErrorMessage.MINIMUM_NUMBER_OF_CARS);
        }
    }

    public static void validateNumeric(final String input) {
        try {
            int number = Integer.parseInt(input);
            validateNegativeNumber(number);
        } catch (NumberFormatException e) {
            throw RacingException.of(ErrorMessage.INVALID_ATTEMPT_COUNT_FORMAT);
        }
    }

    private static void validateNegativeNumber(final int number) {
        if (number < 0) {
            throw RacingException.of(ErrorMessage.NEGATIVE_NUMBER);
        }
    }
}