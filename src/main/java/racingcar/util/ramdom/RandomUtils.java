package racingcar.util.ramdom;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomUtils {

    public static int generateRandomNumber(RandomRange randomRange) {
        validate(randomRange);
        return Randoms.pickNumberInRange(randomRange.min(), randomRange.max());
    }

    private static void validate(RandomRange randomRange) {
        if (randomRange.min() > randomRange.max()) {
            throw new IllegalArgumentException("최소값이 최대값보다 클 수 없습니다.");
        }
    }
}
