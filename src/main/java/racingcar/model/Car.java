package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exceptions.RacingCarExceptionHandler;
import racingcar.exceptions.RacingCarExceptionMessage;

public class Car {
    private final String name;
    private int score;

    public Car(String name) {
        if (name.length() > 5) {
            RacingCarExceptionHandler.getException(RacingCarExceptionMessage.CAR_NAME_CANNOT_EXCEED_FIVE);
        }
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore() {
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