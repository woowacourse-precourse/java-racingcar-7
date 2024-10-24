package racingcar.model;

import racingcar.exception.CarException;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(CarException.CAR_NAME_IS_NULL_OR_EMPTY.getMessage());
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(CarException.CAR_NAME_IS_OVER_FIVE.getMessage());
        }
    }
}