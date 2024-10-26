package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public int getNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
