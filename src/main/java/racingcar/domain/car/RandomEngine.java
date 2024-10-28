package racingcar.domain.car;

public class RandomEngine {
    private static final RandomEngine INSTANCE = new RandomEngine();

    private RandomEngine () {}

    public static RandomEngine getInstance() {
        return INSTANCE;
    }
}
