package racingcar.utils;

public class TestRandomNumberGenerator implements NumberGenerator{
    private final int fixedValue;

    public TestRandomNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return fixedValue;
    }
}