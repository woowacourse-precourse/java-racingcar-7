package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static int getRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
