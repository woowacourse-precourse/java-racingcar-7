package racingcar.validation;

import racingcar.constant.ErrorMessage;
import racingcar.model.Car;

public class CarValidator implements Validator {
    @Override
    public Class<?> supportsType() {
        return Car.class;
    }

    @Override
    public void validate(Object target) {
        String name = (String) target;
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }
    }
}

