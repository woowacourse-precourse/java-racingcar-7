package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.NumberConstant;

public class RandomUtil {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER);
    }
}
