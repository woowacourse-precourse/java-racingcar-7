package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exceptions.RacingCarExceptionHandler;
import racingcar.exceptions.RacingCarExceptionMessage;

public class Car {
    private final int ADDED_SCORE = 1;
    private final int MIN_PICK_NUM = 0;
    private final int MAX_PICK_NUM = 9;
    private final int CAN_DRIVE_NUM = 4;
    private final String name;
    private int score;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.score = 0;
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty()) {
            RacingCarExceptionHandler.throwException(RacingCarExceptionMessage.CAR_NAME_LENGTH_CANNOT_BE_ZERO);
        }
        if (carName.length() > 5) {
            RacingCarExceptionHandler.throwException(RacingCarExceptionMessage.CAR_NAME_CANNOT_EXCEED_FIVE);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    private void addScore() {
        this.score += ADDED_SCORE;
    }

    public void drive() {
        if (Randoms.pickNumberInRange(MIN_PICK_NUM, MAX_PICK_NUM) >= CAN_DRIVE_NUM) {
            addScore();
        }
    }

    public String scoreToDash(int score) {
        return "-".repeat(Math.max(0, score));
    }
}