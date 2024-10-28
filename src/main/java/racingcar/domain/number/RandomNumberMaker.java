package racingcar.domain.number;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker implements NumberMaker {
    private static final int MIN = 0;
    private static final int MAX = 9;

    @Override
    public int make() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }

}
