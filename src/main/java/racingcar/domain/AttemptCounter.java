package racingcar.domain;

public class AttemptCounter {
    private final static int MIN = 0;
    private final static int MAX = 100;
    private int attemptNumber;

    public AttemptCounter(int attemptNumber) {
        validateAttemptRange(attemptNumber);
        this.attemptNumber = attemptNumber;
    }

    public boolean isEndAttempt() {
        return attemptNumber <= 0;
    }

    public void decrease() {
        this.attemptNumber--;
    }

    private void validateAttemptRange(int attemptNumber) {
        if (attemptNumber <= MIN || attemptNumber > MAX) {
            throw new IllegalArgumentException("시도 횟수는 1~100까지 입력 가능합니다.");
        }
    }

}
