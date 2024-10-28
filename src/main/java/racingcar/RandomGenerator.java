package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
