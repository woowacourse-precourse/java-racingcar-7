package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomGenerator {
    public static int picNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
