package racingcar.domain;

public class Race {
    private final static String NOT_VALIDATE_NUMBER = "유효하지 않은 숫자 형식입니다.";
    private static final String IS_NOT_TRY_COUNT = "유효한 시도횟수가 아닙니다.";
    private int tryCount;

    public Race(String inputTryCount) {
        this.tryCount = convertToInt(inputTryCount);
    }

    private static void validateTryCount(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(IS_NOT_TRY_COUNT);
        }
    }

    private int convertToInt(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            validateTryCount(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER);
        }
    }
}
