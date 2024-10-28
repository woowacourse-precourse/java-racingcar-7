package racingcar.wrapper;

import racingcar.validator.CarNameValidator;

public class CarName {

    private final String name;

    private CarName(String name) {
        CarNameValidator.validateCarName(name);
        this.name = name.trim();
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

}

