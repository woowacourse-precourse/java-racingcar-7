package racingcar.domain.fake;

import racingcar.domain.CarForwardCondition;

public class FakeRandomNumberGenerator implements CarForwardCondition {

    private static final int MIN_RANDOM_NUMBER_TO_MOVE_CAR = 4;

    @Override
    public boolean determineCarToForward() {
        return makeFakeNumber()>MIN_RANDOM_NUMBER_TO_MOVE_CAR;
    }

    private int makeFakeNumber() {
        return 5;
    }
}
