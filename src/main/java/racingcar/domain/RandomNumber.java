package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    public static int getRandomNumber() {
        return pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
