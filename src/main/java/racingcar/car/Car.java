package racingcar.car;

import static racingcar.global.util.Validator.ValidateCarName;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
        ValidateCarName(name);
    }

    public String getName() {
        return name;
    }
}
