package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomForwardGenerator {

    public static int randomSingleDigitNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}