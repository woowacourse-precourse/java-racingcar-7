package racingcar.config;

public class RandomNumberConfig {
    private static final int RANDOM_NUMBER_MAX_RANGE = 9;
    private static final int RANDOM_NUMBER_MIN_RANGE = 0;
    private static final int MOVE_STAND_NUMBER = 4;

    private RandomNumberConfig() {
    }

    public static int getRandomNumberMaxRange() {
        return RANDOM_NUMBER_MAX_RANGE;
    }

    public static int getRandomNumberMinRange() {
        return RANDOM_NUMBER_MIN_RANGE;
    }

    public static int getMoveStandNumber() {
        return MOVE_STAND_NUMBER;
    }
}
