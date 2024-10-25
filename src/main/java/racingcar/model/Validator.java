package racingcar.model;

import java.util.List;

public class Validator {

    public void validateCarNames(List<String> CarNames) {
        for (String carName : CarNames) {
            validateNotEmpty(carName);
        }
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
