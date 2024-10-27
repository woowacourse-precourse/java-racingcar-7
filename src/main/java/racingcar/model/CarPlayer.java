package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.constant.Constant;

public class CarPlayer {
    private String name;
    private String steps = "";
    private int stepCount;

    public void move() {
        if (canMove()) {
            stepCount++;
            steps += Constant.STEP_UNIT;
        }
        steps += "";
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(Constant.RANDOM_RANGE_MIN, Constant.RANDOM_RANGE_MAX)
                >= Constant.RANDOM_NUMBER_FOR_MOVE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public int getStepCount() {
        return stepCount;
    }
}
