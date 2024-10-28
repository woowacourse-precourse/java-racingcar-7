package racingcar.model;

public record Number(int value) {

    public static final int MAX_VALUE = 100;

    public static Number of(String value) {
        validateValueIsNotEmpty(value);
        validateValueIsInteger(value);
        int tmpValue = Integer.parseInt(value);
        validateValueIsPositiveNumber(tmpValue);
        validateValueLessThenMaxValue(tmpValue);

        return new Number(tmpValue);
    }

    private static void validateValueIsNotEmpty(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력하세요.");
        }
    }

    private static void validateValueIsInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력하세요.");
        }
    }

    private static void validateValueIsPositiveNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("양수만 입력하세요.");
        }
    }

    private static void validateValueLessThenMaxValue(int value) {
        if (value > MAX_VALUE) {
            throw new IllegalArgumentException("시도 횟수는 최대 " + MAX_VALUE + "번까지 가능합니다.");
        }
    }

}
