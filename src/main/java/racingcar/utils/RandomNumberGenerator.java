package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.constants.Constants.MAX_RANDOM_NUMBER;
import static racingcar.constants.Constants.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {

    }

    public static int getRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
