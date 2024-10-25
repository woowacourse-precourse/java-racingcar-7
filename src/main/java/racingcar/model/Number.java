package racingcar.model;

public class Number {

    private final int value;

    public Number(String value) {
        validateValueIsNotEmpty(value);

        this.value = validateValueIsInteger(value);
        validateValueIsPositiveNumber();
    }

    private static void validateValueIsNotEmpty(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력하세요.");
        }
    }

    private int validateValueIsInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력하세요.");
        }
    }

    private void validateValueIsPositiveNumber() {
        if (this.value <= 0) {
            throw new IllegalArgumentException("양수만 입력하세요.");
        }
    }

    public int getValue() {
        return this.value;
    }

}
