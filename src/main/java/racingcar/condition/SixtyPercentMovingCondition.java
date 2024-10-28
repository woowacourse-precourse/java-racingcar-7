package racingcar.condition;

import camp.nextstep.edu.missionutils.Randoms;

public class SixtyPercentMovingCondition implements MovingCondition {
    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
