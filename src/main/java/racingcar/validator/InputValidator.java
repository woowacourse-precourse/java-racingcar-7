package racingcar.validator;

import static racingcar.message.ExceptionMessage.*;

public class InputValidator {
    public void validateNameInput(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION.getMessage());
        }
    }

    public void validateNumberInput(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_EXCEPTION.getMessage());
        }
    }
}
