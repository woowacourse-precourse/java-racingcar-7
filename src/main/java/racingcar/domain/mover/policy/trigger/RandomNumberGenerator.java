package racingcar.domain.mover.policy.trigger;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int run() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
