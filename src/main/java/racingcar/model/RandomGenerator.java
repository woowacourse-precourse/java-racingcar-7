package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int getRandomNumber(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
