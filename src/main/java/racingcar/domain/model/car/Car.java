package racingcar.domain.model.car;

import racingcar.infrastructure.exception.EmptyNameException;
import racingcar.infrastructure.exception.InvalidNameLengthException;
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
            throw new InvalidNameLengthException();
        }
    }

    private static void validateEmpty(final String name) {
        if (name.trim().isEmpty()) {
            throw new EmptyNameException();
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
