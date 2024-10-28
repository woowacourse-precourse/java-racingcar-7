package racingcar.validator;

import racingcar.enums.Exceptions;

public class TrialCountValidator {

    public TrialCountValidator() {
    }

    public void validateTrialCount(String input) {
        validateNotBlank(input);
        validateNumeric(input);
    }

    void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT_EMPTY.getMessage());
        }
    }

    void validateNumeric(String input) {
        String regex = "^[1-9]\\d*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(Exceptions.INVALID_TRY_COUNT.getMessage());
        }
    }
}
