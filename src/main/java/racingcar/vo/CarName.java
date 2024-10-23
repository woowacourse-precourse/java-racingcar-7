package racingcar.vo;

import static racingcar.ErrorCode.CAR_NAME_EMPTY;
import static racingcar.ErrorCode.CAR_NAME_LENGTH_EXCEEDED;

public record CarName(String value) {

    private static final int MAXIMUM_CAR_NAME_LENGTH_CRITERION = 5;

    public CarName {
        validate(value);
    }

    protected void validate(final String name) {
        validateCarNameLength(name);
        validateCarNameNotEmpty(name);
    }

    private static void validateCarNameNotEmpty(final String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    private static void validateCarNameLength(final String carNames) {
        if (carNames.length() > MAXIMUM_CAR_NAME_LENGTH_CRITERION) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }
}
