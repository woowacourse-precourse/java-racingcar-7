package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil implements Random {

    @Override
    public int pickNumberInRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
