package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class MockCar extends Car {
    private final int SPEED = 1;

    public MockCar(String name) {
        super(name);
    }

    @Override
    public void drive() {
        distance += SPEED;
    }
}
