package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generateRandomNum(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
