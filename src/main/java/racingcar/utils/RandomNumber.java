package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.Constraints;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int getNumber() {
        return Randoms.pickNumberInRange(Constraints.MIN_MOVE_RANGE.getValue(), Constraints.MAX_MOVE_RANGE.getValue());
    }
}
