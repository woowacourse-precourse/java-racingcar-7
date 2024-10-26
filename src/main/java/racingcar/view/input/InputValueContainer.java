package racingcar.view.input;

import java.util.List;

public class InputValueContainer {

    private List<String> carNames;
    private int attemptCount;

    public InputValueContainer(List<String> carNames, int attemptCount) {
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
