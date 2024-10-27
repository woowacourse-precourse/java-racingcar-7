package racingcar.domain;

import static racingcar.error.ErrorType.CAR_NAME_LENGTH_ERROR;

public class Car {
    private final static int CAR_NAME_MAX_LENGTH = 5;
    private final static int CAR_NAME_MIN_LENGTH = 1;
    private final String name;
    private int position;

    public Car(final String name, final int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final int distance) {
        position += distance;
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH || name.length() < CAR_NAME_MIN_LENGTH) {
            String message = String.format(CAR_NAME_LENGTH_ERROR.getMessage(), CAR_NAME_MIN_LENGTH,
                    CAR_NAME_MAX_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

}
