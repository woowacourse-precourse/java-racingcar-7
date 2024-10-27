package racingcar.model.car;

import static racingcar.model.ExceptionMessages.Car.LENGTH_OF_NAME_EXCEED;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(String name) {
        validateNameLength(name);

        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(LENGTH_OF_NAME_EXCEED);
        }
    }

    public void move() {
        this.position++;
    }
}
