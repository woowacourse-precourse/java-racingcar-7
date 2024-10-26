package racingcar.input;

import static racingcar.Message.ExceptionMessages.*;

public class InputValidator {
    public void validateNameInput() {
        throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION.getMessage());
    }

    public void validateNumberInput() {
        throw new IllegalArgumentException(NEGATIVE_ATTEMPT_EXCEPTION.getMessage());
    }
}
