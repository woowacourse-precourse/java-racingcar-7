package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GetRandomValue {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
