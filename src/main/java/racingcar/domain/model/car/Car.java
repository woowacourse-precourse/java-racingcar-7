package racingcar.domain.model.car;

import racingcar.infrastructure.constant.ExceptionMessage;
import racingcar.infrastructure.constant.CarConstants;

public class Car {
    private int distance;
    private final String name;

    private Car(final String name) {
        this.distance = 0;
        this.name = name;
    }

    public static Car from(final String name) {
        validateLength(name);
        validateEmpty(name);
        return new Car(name.trim());
    }

    private static void validateLength(final String name) {
        if (name.trim().length() > CarConstants.MAX_LEN) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME_LENGTH);
        }
    }

    private static void validateEmpty(final String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_NAME);
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance++;
    }

    private String getDistanceText() {
        return String.valueOf(CarConstants.DISTANCE).repeat(distance);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, getDistanceText());
    }
}
