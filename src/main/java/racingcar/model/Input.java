package racingcar.model;

import java.util.List;

public class Input {
    private final List<String> carNames;
    private final int tryCount;

    public Input(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}