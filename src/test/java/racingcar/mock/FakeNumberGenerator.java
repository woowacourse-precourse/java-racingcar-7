package racingcar.mock;

import racingcar.util.NumberGenerator;

public class FakeNumberGenerator implements NumberGenerator {
    private int number;

    private FakeNumberGenerator(int number) {
        this.number = number;
    }

    public static FakeNumberGenerator of(int number) {
        return new FakeNumberGenerator(number);
    }

    @Override
    public int generate() {
        return number;
    }
}
