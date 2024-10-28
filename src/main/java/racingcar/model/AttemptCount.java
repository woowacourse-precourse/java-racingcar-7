package racingcar.model;

public class AttemptCount {

    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 이상의 숫자를 입력해주세요.";
    private static final int MINIMUM = 0;
    private final int count;

    public AttemptCount(int count) {
        validateNumber(count);
        this.count = count;
    }

    private void validateNumber(int count) {
        if (isOutOfRange(count)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(int count) {
        return count <= MINIMUM;
    }

    public int getCount() {
        return count;
    }
}
