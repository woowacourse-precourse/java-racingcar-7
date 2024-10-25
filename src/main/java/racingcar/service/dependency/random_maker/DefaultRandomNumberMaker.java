package racingcar.service.dependency.random_maker;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberMaker implements RandomNumberMaker {

    private static final int RANDOM_NUMBER_BOUND = 9;
    private static final int RANDOM_NUMBER_MIN = 0;

    @Override
    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_BOUND);
    }
}
