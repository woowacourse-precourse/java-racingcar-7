package racingcar.domain;

import static racingcar.util.InputValidator.validateNotBlank;

public class Car {
    private final String name;
    private final Integer distance;

    public Car(String name, Integer distance) {
        validateNotBlank(name);
        this.name = name;
        this.distance = distance;
        validateCarNameLength();
    }

    private void validateCarNameLength() {
        if (this.name.length() > 5)
            throw new IllegalArgumentException();
    }
}
