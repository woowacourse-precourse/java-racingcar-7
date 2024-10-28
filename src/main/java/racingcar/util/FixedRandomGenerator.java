package racingcar.util;

public class FixedRandomGenerator implements RandomGenerator {
    private final int fixedValue;

    public FixedRandomGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int pickNumberInRange(int min, int max) {
        return fixedValue;
    }
}
