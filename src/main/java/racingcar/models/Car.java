package racingcar.models;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exceptions.ErrorMessages;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private int distance;
    private String name;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NAME_TOO_LONG);
        }
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NAME_TOO_SHORT);
        }
    }

    public void incrementDistance() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

}