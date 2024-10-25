package racingcar.model;

import racingcar.exception.CarException;

public class Car {
    private static final int MINIMUM_MOVE_NUMBER = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int seed) {
        if (seed < MINIMUM_MOVE_NUMBER) {
            return;
        }
        position++;
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