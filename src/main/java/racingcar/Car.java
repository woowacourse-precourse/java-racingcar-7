package racingcar;

import static racingcar.RacingConstants.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.ViewConstants.MOVE_SYMBOL;
import static racingcar.ViewConstants.NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.ViewConstants.RACE_DISPLAY_FORMAT;

public class Car implements Comparable<Car> {
    private final String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        validateLengthOf(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    private void validateLengthOf(String name) {
        if (name == null || name.isBlank() || (name.length() > MAX_LENGTH_OF_CAR_NAME)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public int moveForwardIf(boolean possible) {
        if (possible) {
            moveCount++;
            return moveCount;
        }
        return -1;
    }

    public boolean isSameMoveCount(Car other) {
        return other.moveCount == this.moveCount;
    }

    @Override
    public int compareTo(Car other) {
        return this.moveCount - other.moveCount;
    }

    public String getStatus() {
        return String.format(RACE_DISPLAY_FORMAT, name).concat(MOVE_SYMBOL.repeat(moveCount));
    }

    public String getName() {
        return name;
    }
}
