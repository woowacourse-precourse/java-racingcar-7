package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static int getNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

}
