package racingcar.controller;

import racingcar.model.RandomNumberGenerator;

public class MockRandomNumberGenerator implements RandomNumberGenerator {
    private final int fixedNumber;

    public MockRandomNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}