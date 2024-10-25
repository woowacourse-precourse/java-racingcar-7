package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {

    public static int getRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
