package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovement {
    private static final int MOVE_CONDITION = 4;

    public CarMovement() {}

    public boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MOVE_CONDITION;
    }
}
