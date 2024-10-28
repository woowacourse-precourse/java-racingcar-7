package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker implements RandomNumberGenerator{
    @Override
    public int move() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
