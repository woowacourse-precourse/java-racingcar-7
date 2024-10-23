package racingcar.presentation;

import java.util.Objects;
import racingcar.ErrorMessage;

public class InputValidator {
    private static final String POSITIVE_INTEGER_REGEX = "\\d+";

    private InputValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateBlank(String rawInput){
        if (Objects.isNull(rawInput) || rawInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_CAR_NAME.getMessage());
        }
    }

    public static void validatePositiveInteger(String rawInput){
        validateBlank(rawInput);

        if (!rawInput.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_INTEGER_ALLOWED.getMessage());
        }
    }
}
