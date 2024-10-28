package racingcar.util;

import static racingcar.config.RandomNumberConfig.RANDOM_NUMBER_MAX_RANGE;
import static racingcar.config.RandomNumberConfig.RANDOM_NUMBER_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
    }
}
