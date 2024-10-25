package racingcar.model;

import static racingcar.constants.ErrorMessages.INVALID_RACER_NAME_BLANK;
import static racingcar.constants.ErrorMessages.INVALID_RACER_NAME_RANGE;

public class CarRacer {
    private final String name;

    public CarRacer(String name) {
        validateName(name);
        this.name = name;
    }

    public String getRacerName() {
        return this.name;
    }

    private void validateName(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_RACER_NAME_BLANK.getMessage());
        }
    }

    private void validateLength(String name) {
        if (!isProperLength(name)) {
            throw new IllegalArgumentException(INVALID_RACER_NAME_RANGE.getMessage());
        }
    }

    private boolean isProperLength(String name) {
        return name.length() <= 5;
    }
}
