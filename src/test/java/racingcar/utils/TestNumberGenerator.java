package racingcar.utils;

public class TestNumberGenerator implements NumberGenerator {
    private final int fixedValue;

    public TestNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}