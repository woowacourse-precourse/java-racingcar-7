package racingcar.domain.random;

public class CarStateNumber implements RandomNumberGenerator {

    private static final int FIXED_NUMBER = 4;

    @Override
    public int generateRandomNumber() {
        return FIXED_NUMBER;
    }
}
