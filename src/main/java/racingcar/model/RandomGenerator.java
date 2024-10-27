package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Boolean canMoveForward(int randomNumber) {
        return randomNumber >= 4;
    }
}
