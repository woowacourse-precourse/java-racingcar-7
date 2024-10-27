package racingcar.config;

public class RandomNumberConfig {
    private static final int RANDOM_NUMBER_MAX_RANGE = 9;
    private static final int RANDOM_NUMBER_MIN_RANGE = 0;

    private RandomNumberConfig() {
    }

    public static int getRandomNumberMaxRange() {
        return RANDOM_NUMBER_MAX_RANGE;
    }

    public static int getRandomNumberMinRange() {
        return RANDOM_NUMBER_MIN_RANGE;
    }
}
