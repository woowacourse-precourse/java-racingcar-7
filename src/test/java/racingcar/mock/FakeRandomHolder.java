package racingcar.mock;

import racingcar.car.service.port.RandomHolder;

public class FakeRandomHolder implements RandomHolder {
    private int random;

    public FakeRandomHolder(int random) {
        this.random = random;
    }

    @Override
    public int getRandom() {
        return random;
    }
}
