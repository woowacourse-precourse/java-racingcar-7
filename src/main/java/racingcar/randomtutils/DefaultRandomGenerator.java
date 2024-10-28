package racingcar.randomtutils;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomGenerator implements RandomGenerator{
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}
