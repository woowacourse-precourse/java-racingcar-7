package racingcar.operator;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public int ExtractRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
