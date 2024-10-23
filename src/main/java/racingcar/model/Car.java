package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVEMENT_BASE = 0;
    private static final int MOVE_FORWARD_AMOUNT = 1;
    private static final int MOVING_CRITERIA = 4;
    private static final int MOVING_CRITERIA_FROM = 0;
    private static final int MOVING_CRITERIA_TO = 9;

    private int movement;

    public Car() {
        this.movement = MOVEMENT_BASE;
    }

    private boolean decideToMove() {
        return Randoms.pickNumberInRange(MOVING_CRITERIA_FROM, MOVING_CRITERIA_TO) >= MOVING_CRITERIA;
    }

    public void moveForward() {
        if (decideToMove()) {
            movement += MOVE_FORWARD_AMOUNT;
        }
    }

    public int getMovement() {
        return movement;
    }
}
