package racingcar.Domain;

import racingcar.Validator.CarNameValidator;

public class CarName {
    private final String value;

    private CarName(String value) {
        CarNameValidator.validate(value);
        this.value = value;
    }

    public static CarName from(String value) {
        return new CarName(value);
    }

    public String getValue() {
        return value;
    }

}
