package racingcar.util.ramdom;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.ExceptionFactory;

import static racingcar.exception.ExceptionType.MIN_GREATER_THAN_MAX;

public final class RandomUtils {

    public static int generateRandomNumber(RandomRange randomRange) {
        validate(randomRange);
        return Randoms.pickNumberInRange(randomRange.min(), randomRange.max());
    }

    private static void validate(RandomRange randomRange) {
        if (randomRange.min() > randomRange.max()) {
            throw ExceptionFactory.createException(MIN_GREATER_THAN_MAX);
        }
    }
}
