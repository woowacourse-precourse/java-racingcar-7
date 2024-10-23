package racingcar.domain;

public class AttemptManager {
    private final int attemptNumber;

    public AttemptManager(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

}
