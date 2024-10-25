package racingcar.domain.random_number;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomNumber {

    public static final int MAX_MOVEMENT_VALUE = 9;
    public static final int MIN_MOVEMENT_VALUE = 0;
    private static RandomNumberGenerator instance;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        if (instance == null)
            instance = new RandomNumberGenerator();
        return instance;
    }

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_MOVEMENT_VALUE, MAX_MOVEMENT_VALUE);
    }
}
