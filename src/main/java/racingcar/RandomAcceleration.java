package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomAcceleration implements Acceleration {

    @Override
    public int generateForwardCriterion() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
