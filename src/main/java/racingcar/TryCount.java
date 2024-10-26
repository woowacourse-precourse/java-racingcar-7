package racingcar;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;

    private final int value;

    private TryCount(int value) {
        validateMinimumTryCount(value);
        this.value = value;
    }

    public static TryCount of(String value) {
        try {
            return new TryCount(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateMinimumTryCount(int value) {
        if (value < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_TRY_COUNT + "이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
