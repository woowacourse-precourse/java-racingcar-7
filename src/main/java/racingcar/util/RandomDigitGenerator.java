package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.NumberConstant;

import static racingcar.domain.NumberConstant.*;

public class RandomDigitGenerator {

    public int generateDigit() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
    }
}
