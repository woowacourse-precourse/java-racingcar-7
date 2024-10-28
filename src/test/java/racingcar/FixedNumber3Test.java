package racingcar;

import racingcar.util.RandomNumberGenerator;

public class FixedNumber3Test implements RandomNumberGenerator {
    @Override
    public int move() {
        return 3;
    }
}
