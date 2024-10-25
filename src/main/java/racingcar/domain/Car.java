package racingcar.domain;

import static racingcar.exception.ExceptionMessage.OVER_MAX_CAR_NAME;

public class Car {

    private static final int MOVING_STANDARD_NUMBER = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private String name;
    private int movedDistance;

    public Car(String name) {
        verifyValidCarName(name);
        this.name = name;
    }

    public int move(int randomNumber) {
        if (randomNumber >= MOVING_STANDARD_NUMBER) {
            movedDistance++;
        }
        return movedDistance;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    private void verifyValidCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_MAX_CAR_NAME.getMessage());
        }
    }
}
