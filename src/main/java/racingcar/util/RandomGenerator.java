package racingcar.util;

import static racingcar.constants.Symbol.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private static final Integer MOVABLE_MIN_NUMBER = 4;
    private static final Integer RANDOM_MAX_NUMBER = 9;
    public static boolean Movable() {
        return generateRandomNumber() >= MOVABLE_MIN_NUMBER;
    }
    private static Integer generateRandomNumber(){
        return Randoms.pickNumberInRange(ZERO, RANDOM_MAX_NUMBER);
    }

}
