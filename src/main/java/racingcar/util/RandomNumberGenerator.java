package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int maxBound = 10;

    public RandomNumberGenerator() {
    }

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,maxBound);
    }
}
