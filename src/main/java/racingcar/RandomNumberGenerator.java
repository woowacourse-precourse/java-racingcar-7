package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomGenerator{
    private static final int MIN_RANDOM_DIGIT = 0;
    private static final int MAX_RANDOM_DIGIT = 9;

    @Override
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_DIGIT, MAX_RANDOM_DIGIT);
    }
}
