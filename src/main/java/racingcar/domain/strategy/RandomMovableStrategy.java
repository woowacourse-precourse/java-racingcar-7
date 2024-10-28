package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovableStrategy implements MovableStrategy {

    @Override
    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
