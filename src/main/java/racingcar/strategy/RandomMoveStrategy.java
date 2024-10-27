package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.MoveEvent;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public MoveEvent moveOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return MoveEvent.MOVE;
        }

        return MoveEvent.STOP;
    }
}
