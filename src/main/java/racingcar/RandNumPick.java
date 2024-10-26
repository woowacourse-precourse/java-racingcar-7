package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandNumPick {
    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
