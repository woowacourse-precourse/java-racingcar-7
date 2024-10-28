package racingcar.model;

import java.util.Set;

public class Game {
    private final Set<String> carNames;
    private final int attemptCount;

    public Game(Set<String> carNames, int attemptCount) {
        this.carNames = carNames;
        this.attemptCount = attemptCount;
    }

    public Set<String> getCarNames() {
        return carNames;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
