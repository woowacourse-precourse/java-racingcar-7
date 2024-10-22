package racingcar.domain;

import static racingcar.exception.constants.ErrorMessage.CAR_NAME_LENGTH_EXCEEDED;
import static racingcar.exception.constants.ErrorMessage.EMPTY_CAR_NAME_NOT_ALLOWED;

import racingcar.exception.RacingCarException;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new RacingCarException(EMPTY_CAR_NAME_NOT_ALLOWED.getMessage());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }
}
