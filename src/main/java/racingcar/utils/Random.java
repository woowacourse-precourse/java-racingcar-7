package racingcar.utils;

import static racingcar.constant.NumberType.MAX_RANDOM_NUMBER;
import static racingcar.constant.NumberType.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public final class Random {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getNumber(), MAX_RANDOM_NUMBER.getNumber());
    }
}
