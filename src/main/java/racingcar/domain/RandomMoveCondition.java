package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveCondition {
    private final int STANDARD = 4;

    @Override
    public boolean isSatisfied() {
        return Randoms.pickNumberInRange(0, 9) > STANDARD;
    }
}
