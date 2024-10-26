package racingcar.validator;

import static racingcar.validator.ValidationMessage.INVALID_ATTEMPTS;

public class AttemptValidator {

    public void validate(String input) {
        validInteger(input);
        validAttempt(input);
    }

    private void validInteger(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(INVALID_ATTEMPTS.getMessage());
        }
    }

    private void validAttempt(String input) {
        int attempt = Integer.parseInt(input);
        if (attempt <= 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPTS.getMessage());
        }
    }
}
