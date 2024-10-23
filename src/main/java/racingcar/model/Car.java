package racingcar.model;

import racingcar.exception.RacingCarErrorMessage;

public class Car {
    private final String name;
    private int moveCount;

    public Car(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(RacingCarErrorMessage.CAR_NAME_BLANK_ERROR.getMessage());
        }

        if(name.length() > 5) {
            throw new IllegalArgumentException(RacingCarErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
        }

        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount(int randomNumber) {
        return moveCount;
    }

    public void move(int randomNumber) {
        if(randomNumber >= 4) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
