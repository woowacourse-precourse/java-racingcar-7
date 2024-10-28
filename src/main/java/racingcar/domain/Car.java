package racingcar.domain;

import static racingcar.validation.ErrorMessage.OVER_MAX_CAR_NAME;

public class Car {

    private static final int MOVING_STANDARD_NUMBER = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private int movedDistance;

    public Car(String name) {
        validateCarNameLength(name);
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

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_MAX_CAR_NAME.getMessage());
        }
    }
}
