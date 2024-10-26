package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.constant.Constant;


public class CarPlayer {
    private String name;
    private String steps;
    private int moveCount;

    public void move() {
        if (canMove()) {
            steps += Constant.STEP_UNIT;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(Constant.RANDOM_RANGE_MIN, Constant.RANDOM_RANGE_MAX)
                >= Constant.RANDOM_NUMBER_FOR_MOVE;
    }

    public int getMoveCount() {
        return steps.length();
    }

    public String getSteps() {
        return steps;
    }

}
