package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int MOVABLE_VALUE = 4;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public Boolean canMoveForward(int randomNumber) {
        return randomNumber >= MOVABLE_VALUE;
    }
}
