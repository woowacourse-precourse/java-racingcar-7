package racingcar.infrastructures.racing;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.racing.RacingStrategy;

public class RandomRacingStrategy implements RacingStrategy {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER_TO_MOVE_CAR = 4;

    @Override
    public boolean determineCarToForward() {
        return makeRandomNumber()>=MIN_RANDOM_NUMBER_TO_MOVE_CAR;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
