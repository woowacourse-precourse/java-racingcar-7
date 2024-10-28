package racingcar.validation;

import static racingcar.validation.Exceptions.BLANK_CAR_NAME;
import static racingcar.validation.Exceptions.INSUFFICIENT_CAR_NAME_LENGTH;

public class CarValidator implements Validator<String> {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public void validate(String carName) {
        validateLength(carName);
        validateBlank(carName);
    }

    private void validateLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INSUFFICIENT_CAR_NAME_LENGTH.getMsg());
        }
    }

    private void validateBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMsg());
        }
    }
}
