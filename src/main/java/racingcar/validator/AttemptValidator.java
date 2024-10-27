package racingcar.validator;

public class AttemptValidator {
    public static final String NON_NUMERIC_MESSAGE = "숫자를 입력해주세요";
    public static final String NEGATIVE_ATTEMPT_MESSAGE = "0이하의 정수는 입력할 수 없습니다.";
    private AttemptValidator() {
        throw new IllegalStateException("Validator Class");
    }

    public static void validateAttempt(String attempt) {
        validateNumericInput(attempt);
        validateNegativeInput(attempt);
    }

    private static void validateNumericInput(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }

    private static void validateNegativeInput(String attempt) {
        int attemptNumber = Integer.parseInt(attempt);
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_MESSAGE);
        }
    }
}
