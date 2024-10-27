package model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int getRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
