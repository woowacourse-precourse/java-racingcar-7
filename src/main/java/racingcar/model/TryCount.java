package racingcar.model;

public class TryCount {

    private static final String INVALID_NUMERIC_MESSAGE = "시도 횟수는 숫자만 입력 가능합니다.";
    private static final String INVALID_EMPTY_MESSAGE = "시도 횟수에 빈 값을 입력할 수 없습니다.";
    private static final String INVALID_COUNT_RANGE = "입력 가능한 시도 횟수 범위는 1 ~ 10입니다.";

    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 10;

    private final int count;

    private TryCount(int count) {
        validateRange(count);
        this.count = count;
    }

    public static TryCount from(String input) {
        validateNumeric(input);
        validateEmpty(input);
        return new TryCount(Integer.parseInt(input));
    }

    public int getCount() {
        return count;
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_MESSAGE);
        }
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    private void validateRange(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT_RANGE);
        }
    }
}
