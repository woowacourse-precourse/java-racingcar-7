package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int make() {
        return pickNumberInRange(0, 9);
    }
}
