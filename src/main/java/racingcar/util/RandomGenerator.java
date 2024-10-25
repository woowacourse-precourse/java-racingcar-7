package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static boolean Movable() {
        return generateRandomNumber() >= 4;
    }
    private static Integer generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

}
