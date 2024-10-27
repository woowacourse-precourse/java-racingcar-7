package racingcar.config;

public class RandomNumberConfig {
    private static final RandomNumberConfig instance = new RandomNumberConfig();
    private final int RANDOM_NUMBER_MAX_RANGE = 9;
    private final int RANDOM_NUMBER_MIN_RANGE = 0;

    private RandomNumberConfig() {
    }

    public static RandomNumberConfig getInstance() {
        return instance;
    }

    public int getRANDOM_NUMBER_MAX_RANGE() {
        return RANDOM_NUMBER_MAX_RANGE;
    }

    public int getRANDOM_NUMBER_MIN_RANGE() {
        return RANDOM_NUMBER_MIN_RANGE;
    }
}
