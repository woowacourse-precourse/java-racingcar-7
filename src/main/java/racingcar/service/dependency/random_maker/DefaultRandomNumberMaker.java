package racingcar.service.dependency.random_maker;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberMaker implements RandomNumberMaker {

    public final int RANDOM_MAX = 9;
    public final int RANDOM_MIN = 0;

    @Override
    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
