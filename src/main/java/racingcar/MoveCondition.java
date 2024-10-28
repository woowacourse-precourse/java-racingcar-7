package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveCondition implements Condition{
    @Override
    public boolean getCondition() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
