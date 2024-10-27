package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
