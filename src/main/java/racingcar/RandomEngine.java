package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomEngine implements Engine {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MOVING_CONDITION = 4;

    @Override
    public boolean accelerate() {
        int random = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return random >= MOVING_CONDITION;
    }
}
