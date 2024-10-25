package racingcar.util.ramdom;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomUtils {

    public static int generateRandomNumber(RandomRange randomRange) {
        return Randoms.pickNumberInRange(randomRange.min(), randomRange.max());
    }
}
