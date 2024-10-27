package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomGenerator implements RandomNumberGenerator {
    @Override
    public int move() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
