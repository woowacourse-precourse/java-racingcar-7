package racingcar;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomNumberMaker;

public class FixedNumber5Test implements RandomNumberGenerator {
    @Override
    public int move() {
        return 5;
    }
}
