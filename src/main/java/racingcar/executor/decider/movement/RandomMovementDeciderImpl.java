package racingcar.executor.decider.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementDeciderImpl implements RandomMovementDecider {

    @Override
    public boolean decide(int randomNumber) {
        return randomNumber >= 4;
    }
}
