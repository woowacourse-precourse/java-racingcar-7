package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.Constants;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        int value = Randoms.pickNumberInRange(Constants.RANGE_LOWER_BOUND.getValue(),
                Constants.RANGE_UPPER_BOUND.getValue());
        if (value >= Constants.MOVE_CONDITION.getValue()) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
