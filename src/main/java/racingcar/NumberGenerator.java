package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int random(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
