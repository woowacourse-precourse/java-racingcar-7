package racingcar.model;

public class AttemptCount {

    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MAX_ATTEMPT_COUNT = 500;

    private int count;

    public AttemptCount(int count) {
        validate(count);
        this.count = count;
    }

    public boolean isRemain() {
        return count > 0;
    }

    public void decrease() {
        if (!isRemain()) {
            throw new IllegalArgumentException("시도 횟수가 남아있지 않습니다.");
        }
        count--;
    }

    private void validate(int count) {
        if (isOutOfRange(count)) {
            String message = String.format("시도 횟수는 %d~%d사이여야 합니다.", MIN_ATTEMPT_COUNT, MAX_ATTEMPT_COUNT);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isOutOfRange(int count) {
        return count < MIN_ATTEMPT_COUNT || count > MAX_ATTEMPT_COUNT;
    }

}
