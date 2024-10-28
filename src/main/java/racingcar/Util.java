package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Constants.*;

public class Util {

    public static int randomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
