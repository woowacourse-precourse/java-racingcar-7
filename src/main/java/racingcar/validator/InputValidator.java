package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingException;

import java.util.List;

public class InputValidator {

    public static void validateEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw RacingException.of(ErrorMessage.EMPTY_INPUT);
        }
    }

    public static void validateDuplicate(final List<String> names) {
        if (isDuplicated(names)) {
            throw RacingException.of(ErrorMessage.DUPLICATE_CAR_NAME);
        }
    }

    private static boolean isDuplicated(List<String> names) {
        return names.size() != names.stream()
                .distinct()
                .count();
    }

    public static void validateNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw RacingException.of(ErrorMessage.INVALID_ATTEMPT_COUNT_FORMAT);
        }
    }
}