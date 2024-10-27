package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MOVABLE_VALUE = 4;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Boolean canMoveForward(int randomNumber) {
        return randomNumber >= MOVABLE_VALUE;
    }
}
