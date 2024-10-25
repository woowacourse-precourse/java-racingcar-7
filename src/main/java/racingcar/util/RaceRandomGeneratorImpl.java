package racingcar.util;

public class RaceRandomGeneratorImpl implements RaceRandomGenerator {

    private RaceRandomGeneratorImpl() {}

    private static final RaceRandomGeneratorImpl INSTANCE = new RaceRandomGeneratorImpl();

    public static RaceRandomGeneratorImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public long getMoveForwardTimes(long raceTimes) {
        long moveForwardTimes = 0;
        for (long l = 0; l < raceTimes; l++) {
            if (getRandomValue() >= 4) {
                moveForwardTimes++;
            }
        }
        return moveForwardTimes;
    }
}
