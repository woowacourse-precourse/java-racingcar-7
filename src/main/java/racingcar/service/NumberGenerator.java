package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
    
}
