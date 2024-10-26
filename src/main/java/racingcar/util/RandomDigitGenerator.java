package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigitGenerator {

    public int generateDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
