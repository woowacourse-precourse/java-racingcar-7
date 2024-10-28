package racingcar.domain;

public class AttemptNumber {

    private int attemptNumber;

    public AttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void decrease() {
        attemptNumber--;
    }

    public boolean isRemain() {
        return attemptNumber != 0;
    }
}
