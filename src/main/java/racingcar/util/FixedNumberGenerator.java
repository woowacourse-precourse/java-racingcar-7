package racingcar.util;

public class FixedNumberGenerator implements NumberGenerator {
    private final int fixedNumber;

    public FixedNumberGenerator(final int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateNumber(final int min, final int max) {
        return fixedNumber;
    }
}
