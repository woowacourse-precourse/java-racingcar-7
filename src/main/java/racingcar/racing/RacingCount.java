package racingcar.racing;

public class RacingCount {

    public static final int MIN_VALUE = 1;
    private final int value;

    public RacingCount(final String value) {
        final int number = createNumberFormat(value);
        validateValueRange(number);
        this.value = number;
    }

    private int createNumberFormat(final String value) {
        if (value.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

    private void validateValueRange(final int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("시도횟수는 최소 " + MIN_VALUE + "이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
