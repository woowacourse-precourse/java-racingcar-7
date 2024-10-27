package racingcar.model;

import racingcar.model.enums.ExceptionMessage;

import java.util.Objects;

public class Car {
    private String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_CHARACTER_EXCEPTION.getMessage());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_QUANTITY_EXCEPTION.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
