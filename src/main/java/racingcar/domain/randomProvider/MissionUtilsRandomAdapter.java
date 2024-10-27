package racingcar.domain.randomProvider;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionUtilsRandomAdapter implements RandomAdapter {

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
