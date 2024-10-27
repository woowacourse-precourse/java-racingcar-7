package racingcar.executor.decider.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementDeciderImpl implements RandomMovementDecider {

    @Override
    public boolean decide() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
