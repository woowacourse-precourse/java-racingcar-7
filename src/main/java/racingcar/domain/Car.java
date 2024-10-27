package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.exception.CustomException;
import racingcar.global.exception.ErrorMessage;

public class Car {
    private static int NAME_MAX_LENGTH = 5;
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        validName(name);
        this.name = name;
    }

    public void tryMove() {
        if (canMove()) {
            move();
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void validName(String name) {
        if (isNameEmpty(name)) {
            throw CustomException.of(ErrorMessage.BLANK_CAR_NAME_ERROR);
        }
        if (isNameTooLong(name)) {
            throw CustomException.of(ErrorMessage.CAR_NAME_TOO_LONG_ERROR);
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isBlank();
    }

    private boolean isNameTooLong(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }
}
