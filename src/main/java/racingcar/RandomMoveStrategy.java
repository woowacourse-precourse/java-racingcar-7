package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean shouldMove() {
        return pickNumberInRange(0, 9) >= 4;
    }
}
