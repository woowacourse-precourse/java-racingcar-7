package racingcar.domain;

import static racingcar.util.InputValidator.validateNotBlank;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String DISTANCE_SIGN = "-";
    private static final String NAME_DISTANCE_DELIMITER = " : ";
    private static final int MOVE_THRESHOLD = 4;
    private static final int INIT_DISTANCE_VALUE = 0;

    private final String name;
    private Integer distance;

    public Car(final String name) {
        validateNotBlank(name);
        validateNameLength(name);
        this.name = name;
        this.distance = INIT_DISTANCE_VALUE;
    }

    public String getName() {
        return name;
    }

    public int compareDistance(Car otherCar) {
        return this.distance.compareTo(otherCar.distance);
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        return this.name + NAME_DISTANCE_DELIMITER + createHyphenDistance();
    }

    private String createHyphenDistance() {
        return DISTANCE_SIGN.repeat(distance);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException();
    }
}
