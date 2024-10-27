package racingcar.util;

public class FixedNumberGenerator extends RandomNumberGenerator {
    private final int fixedNumber;

    public FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateNumber() {
        return fixedNumber;
    }
}
