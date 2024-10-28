package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGeneratorImpl implements MovementPolicy {
    @Override
    public boolean moveOrStop() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}