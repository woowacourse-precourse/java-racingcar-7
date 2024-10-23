package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker implements NumberMaker {
    private final int MIN = 0;
    private final int MAX = 9;


    @Override
    public int make() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
