package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class ThreadLocalRandomNumberGenerator implements RandomNumberGenerator {


    @Override
    public int pickRandomNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

}
