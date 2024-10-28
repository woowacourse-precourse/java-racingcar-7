package racingcar.move;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
