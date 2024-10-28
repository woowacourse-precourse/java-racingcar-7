package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {

    public static int rolling() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
