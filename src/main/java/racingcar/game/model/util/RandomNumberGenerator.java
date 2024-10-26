package racingcar.game.model.util;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RandomNumberGenerator {
    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_INCLUSIVE = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_INCLUSIVE, MAX_INCLUSIVE);
    }
}