package racingcar.model;

import racingcar.exception.RacingCarErrorMessage;

public class Car {
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int moveCount;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(RacingCarErrorMessage.CAR_NAME_BLANK_ERROR.getMessage());
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(RacingCarErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
        }

        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_NUMBER) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
