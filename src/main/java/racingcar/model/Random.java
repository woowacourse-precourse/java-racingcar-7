package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
