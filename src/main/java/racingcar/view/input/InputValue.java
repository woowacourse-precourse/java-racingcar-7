package racingcar.view.input;

import java.util.List;

public class InputValue {

    private final List<String> carNames;
    private final int attemptCount;

    public InputValue(List<String> carNames, int attemptCount) {
        this.carNames = carNames;
        this.attemptCount = attemptCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
