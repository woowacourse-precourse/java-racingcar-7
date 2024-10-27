package racingcar.util;

public class TestNumberGenerator implements NumberGenerator {
    private final int expectOutputNumber;

    public TestNumberGenerator(int expectOutputNumber) {
        this.expectOutputNumber = expectOutputNumber;
    }

    @Override
    public int generate() {
        return expectOutputNumber;
    }
}
