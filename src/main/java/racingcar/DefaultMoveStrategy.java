package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultMoveStrategy implements MoveStrategy {
    private static final int FORWARD_FLAG = 4;
    @Override
    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= FORWARD_FLAG;
    }
}
