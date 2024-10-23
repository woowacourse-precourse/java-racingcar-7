package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private int randomNumber;

    public RandomNumberGenerator() {
    }

    public int makeRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
