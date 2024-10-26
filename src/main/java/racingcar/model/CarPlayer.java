package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.constant.Constant;


public class CarPlayer {
    private String name;
    private ArrayList<String> steps;

    public void move() {
        if (canMove()) {
            steps.add(Constant.STEP_UNIT);
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(Constant.RANDOM_RANGE_MIN, Constant.RANDOM_RANGE_MAX)
                >= Constant.RANDOM_NUMBER_FOR_MOVE;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

}
