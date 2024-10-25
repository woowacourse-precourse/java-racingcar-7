package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultCarMoveCondition implements CarMoveCondition {

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
