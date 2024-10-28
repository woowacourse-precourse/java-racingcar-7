package racingcar.util.random;

public class RaceRandomGeneratorImpl implements RaceRandomGenerator {

    private static final RaceRandomGeneratorImpl INSTANCE = new RaceRandomGeneratorImpl();

    private RaceRandomGeneratorImpl() {
    }

    public static RaceRandomGeneratorImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean canMoveForward() {
        return getRandomValue() >= 4;
    }
}
