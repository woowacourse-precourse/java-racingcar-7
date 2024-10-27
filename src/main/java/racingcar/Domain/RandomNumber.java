package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public Integer pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
