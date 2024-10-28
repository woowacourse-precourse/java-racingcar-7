package racingcar.domain;

import racingcar.vo.ExceptionMessage;

public class Car {

    private static final int MINIMUM_MOVE_VALUE = 4;
    private static final int DEFAULT_MOVE_COUNT = 0;

    private final String name;
    private int moveCount;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
        this.name = name;
        this.moveCount = DEFAULT_MOVE_COUNT;
    }

    public void moveIfPossible(int number) {
        if (isForwardMovable(number)) {
            this.moveCount++;
        }
    }

    private boolean isForwardMovable(int number) {
        return number >= MINIMUM_MOVE_VALUE;
    }

    public boolean isMoveCountHigher(int maxNum) {
        return moveCount >= maxNum;
    }

    public int compareScore(int maxScore) {
        if (moveCount > maxScore) {
            return moveCount;
        }
        return maxScore;
    }

    public String currentScore() {
        StringBuilder content = new StringBuilder(name).append(" : ");

        for (int i = 0; i < moveCount; i++) {
            content.append("-");
        }

        return content.toString();
    }

    public String getWinner() {
        return name;
    }
}
