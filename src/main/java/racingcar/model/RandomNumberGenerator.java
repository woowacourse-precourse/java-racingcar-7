package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
