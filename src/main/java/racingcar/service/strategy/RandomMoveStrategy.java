package racingcar.service.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isCanMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
