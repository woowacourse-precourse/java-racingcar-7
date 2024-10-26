package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final NumberGenerator INSTANCE = new NumberGenerator();

    private NumberGenerator() {
    }

    public static NumberGenerator getInstance() {
        return INSTANCE;
    }

    public int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
