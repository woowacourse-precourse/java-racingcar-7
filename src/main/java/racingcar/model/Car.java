package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exceptions.RacingCarExceptionHandler;
import racingcar.exceptions.RacingCarExceptionMessage;

public class Car {
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
        this.score += 1;
    }

    public void drive() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            addScore();
        }
    }

    public String scoreToDash(int score) {
        return "-".repeat(Math.max(0, score));
    }
}