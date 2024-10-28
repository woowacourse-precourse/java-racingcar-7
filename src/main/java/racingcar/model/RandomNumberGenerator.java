package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static Integer generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
