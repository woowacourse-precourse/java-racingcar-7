package racingcar.domain;

import static racingcar.validation.Exceptions.BLANK_CAR_NAME;
import static racingcar.validation.Exceptions.INSUFFICIENT_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private String name;
    private int moveDistance;

    public Car(String name) {
        validateCarNameLengthAndBlank(name);
        this.name = name;
        this.moveDistance = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MINIMUM_MOVE_THRESHOLD) {
            moveDistance ++;
        }
    }

    private void validateCarNameLengthAndBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMsg());
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INSUFFICIENT_CAR_NAME_LENGTH.getMsg());
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
