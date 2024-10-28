package racingcar.domain.car;

import static racingcar.exception.Exception.EMPTY_NAME;
import static racingcar.exception.Exception.INVALID_NAME_LENGTH;

import racingcar.strategy.CarDrivingStrategy;
import racingcar.strategy.RandomDrivingStrategy;

public class Car {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int ZERO = 0;

    private final String name;
    private final CarDrivingStrategy strategy;
    private int position;

    public Car(String name, CarDrivingStrategy strategy) {
        validate(name);
        this.strategy = strategy;
        this.name = name;
        this.position = ZERO;
    }

    public Car(final String name) {
        this(name, new RandomDrivingStrategy());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (strategy.driving()) {
            position++;
        }
    }

    private void validate(final String name) {
        validateNonEmpty(name);
        validateLength(name);
    }

    private void validateNonEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }
}
