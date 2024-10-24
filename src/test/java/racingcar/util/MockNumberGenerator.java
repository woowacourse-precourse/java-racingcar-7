package racingcar.util;

public class MockNumberGenerator implements NumberGenerator {
    private final int number;

    public MockNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
