package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
