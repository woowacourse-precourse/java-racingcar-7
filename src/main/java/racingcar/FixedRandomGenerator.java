package racingcar;

public class FixedRandomGenerator implements RandomGenerator {
    private final int fixedValue;

    public FixedRandomGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}
