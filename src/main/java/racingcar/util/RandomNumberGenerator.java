package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.RandomNumberConfig;

public class RandomNumberGenerator {
    private static final RandomNumberConfig randomNumberConfig = RandomNumberConfig.getInstance();

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(randomNumberConfig.getRANDOM_NUMBER_MIN_RANGE(),
                randomNumberConfig.getRANDOM_NUMBER_MAX_RANGE());
    }
}
