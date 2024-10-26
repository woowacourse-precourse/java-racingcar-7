package racingcar.validation;

public class NumberValidator {
    private final static String NOT_NUMBER_ERROR = "시도 횟수는 숫자만 입력해주세요.";
    private final static String NOT_POSITIVE_NUMBER_ERROR = "시도 횟수는 0~100인 숫자만 가능합니다.";

    public static void validateIsNumber(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    public static void validateIsPositive(String attempt) {
        int number = Integer.parseInt(attempt);
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
    }
}
