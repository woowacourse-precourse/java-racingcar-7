package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumber {

    private RandomNumber() {
    }

    public static int generateInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

}
