package racingcar.presentation;

import java.util.Objects;
import racingcar.global.ErrorMessage;

public class InputValidator {
    private static final String POSITIVE_INTEGER_REGEX = "\\d+";

    private InputValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateTrialCountInput(String rawInput){
        ensureNotBlank(rawInput);
        ensurePositiveInteger(rawInput);
    }

    public static void validateCarNamesInput(String rawInput){
        ensureNotBlank(rawInput);
    }

    private static void ensureNotBlank(String rawInput){
        if (Objects.isNull(rawInput) || rawInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_CAR_NAME.getMessage());
        }
    }

    private static void ensurePositiveInteger(String rawInput) {
        if (!rawInput.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_INTEGER_ALLOWED.getMessage());
        }
    }
}