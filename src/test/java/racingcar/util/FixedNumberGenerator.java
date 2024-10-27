package racingcar.util;

public class FixedNumberGenerator implements NumberGenerator {
    private final int fixedNumber;

    private FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    public static FixedNumberGenerator zeroGenerator() {
        return new FixedNumberGenerator(0);
    }

    public static FixedNumberGenerator nineGenerator() {
        return new FixedNumberGenerator(9);
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}
