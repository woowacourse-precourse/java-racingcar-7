package racingcar.model;

import racingcar.validation.CarNameValidator;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = CarNameValidator.validate(name);
    }
}
