package racingcar;

import racingcar.util.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
