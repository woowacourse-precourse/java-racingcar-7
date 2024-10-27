package racingcar.domain.race;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.util.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator create() {
        return new RandomNumberGenerator();
    }

    @Override
    public int generate() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
