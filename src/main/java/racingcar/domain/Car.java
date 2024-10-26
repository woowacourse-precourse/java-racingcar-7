package racingcar.domain;

import racingcar.config.validation.FieldValidation;
import racingcar.config.validation.annotation.Length;

public class Car extends FieldValidation {

    @Length(min = 1, max = 5)
    private final String name;

    private Car(String name) {
        this.name = name;

        super.valid();
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
