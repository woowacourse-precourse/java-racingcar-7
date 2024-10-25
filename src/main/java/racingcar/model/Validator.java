package racingcar.model;

import static racingcar.constant.Constant.*;

import java.util.List;

public class Validator {

    public void validateCarNames(List<String> CarNames) {
        for (String carName : CarNames) {
            validateNotEmpty(carName);
            validateNoSpaces(carName);
            validateMaxLength(carName, MAX_CAR_NAME_LENGTH);
        }
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoSpaces(String input) {
        if (input.contains(SPACE)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMaxLength(String input, int maxLength) {
        if (input.length() > maxLength) {
            throw new IllegalArgumentException();
        }
    }
}
