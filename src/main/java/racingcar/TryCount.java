package racingcar;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;

    private final int value;

    public TryCount(int value) {
        validateMinimumTryCount(value);
        this.value = value;
    }

    private void validateMinimumTryCount(int value) {
        if (value < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_TRY_COUNT + "이상이어야 합니다.");
        }
    }
}
