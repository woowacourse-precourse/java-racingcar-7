package racingcar.numbergenerator;

import racingcar.domain.Car;

public class ExactNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Car.FORWARDING_CONDITION;
    }
}
