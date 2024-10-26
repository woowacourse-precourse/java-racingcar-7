package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int THRESHOLD_NUMBER = 4;
    private static final RandomMovingStrategy instance = new RandomMovingStrategy();

    private RandomMovingStrategy() {
    }

    public static RandomMovingStrategy getInstance() {
        return instance;
    }

    @Override
    public boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

        return randomNumber >= THRESHOLD_NUMBER;
    }
}
