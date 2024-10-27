package racingcar.util;

import static racingcar.config.RandomNumberConfig.getRandomNumberMaxRange;
import static racingcar.config.RandomNumberConfig.getRandomNumberMinRange;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(getRandomNumberMinRange(), getRandomNumberMaxRange());
    }
}
