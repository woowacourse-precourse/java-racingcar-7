package racingcar.domain;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private static RandomNumberGenerator randomGenerator;

    public static RandomNumberGenerator randomNumberGenerator() {
        if (randomGenerator == null) {
            randomGenerator = new RandomNumberGenerator();
        }
        return randomGenerator;
    }

    private RandomNumberGenerator() {

    }

    @Override
    public int generateNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
