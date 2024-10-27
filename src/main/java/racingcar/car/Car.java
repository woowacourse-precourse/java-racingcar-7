package racingcar.car;

import static racingcar.car.constant.Constants.COLON_WITH_SPACE;
import static racingcar.car.constant.Constants.HYPHEN;
import static racingcar.car.constant.Constants.MAX_LENGTH_OF_NAME;
import static racingcar.car.constant.Constants.MOVEABLE_MIN_NUMBER;
import static racingcar.car.constant.ErrorMessage.EMPTY_STRING_NAME_ERROR_MESSAGE;
import static racingcar.car.constant.ErrorMessage.NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.utils.RandomUtils.getRandomValue;

import racingcar.io.OutputManager;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String name) {
        validateEmptyStringName(name);
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void attemptMoving() {
        int randomNumber = getRandomValue();

        if (isMoveableNumber(randomNumber)) {
            move();
        }
    }

    public void attemptMoving(int randomNumber) {
        if (isMoveableNumber(randomNumber)) {
            move();
        }
    }

    public void showStatus() {
        String moveStatus = moveCountToHyphen();
        printStatus(moveStatus);
    }

    public boolean isWinner(int winnerMoveCount) {
        return winnerMoveCount == moveCount;
    }

    private void validateEmptyStringName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING_NAME_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isMoveableNumber(int randomNumber) {
        return randomNumber >= MOVEABLE_MIN_NUMBER;
    }

    private void move() {
        moveCount++;
    }

    private String moveCountToHyphen() {
        return HYPHEN.repeat(moveCount);
    }

    private void printStatus(String moveStatus) {
        OutputManager.printMessage(name + COLON_WITH_SPACE + moveStatus);
    }
}