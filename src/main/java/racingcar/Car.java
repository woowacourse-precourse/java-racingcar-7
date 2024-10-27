package racingcar;

import static racingcar.RacingConstants.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.ViewConstants.NAME_LENGTH_ERROR_MESSAGE;

public class Car {
    private final String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        validateLengthOf(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public int moveForwardIf(boolean possible) {
        if (possible) {
            moveCount++;
            return moveCount;
        }
        return -1;
    }

    public CurrentCar createCurrentCar() {
        return new CurrentCar(name, moveCount);
    }

    private void validateLengthOf(String name) {
        if (name.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
