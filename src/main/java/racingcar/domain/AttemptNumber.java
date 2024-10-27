package racingcar.domain;

public class AttemptNumber {
    private static final String ERROR_MESSAGE_FOR_NOT_INTEGER = "숫자가 아닌 문자를 입력했습니다. 프로그램을 종료합니다.";
    private static final String ERROR_MESSAGE_FOR_NEGATIVE_NUMBER = "음수를 입력했습니다. 프로그램을 종료합니다.";
    private final int attemptNumber;

    private AttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public static AttemptNumber from(String input) {
        int attemptNumber = Integer.parseInt(input);
        return new AttemptNumber(attemptNumber);
    }

    private static int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NOT_INTEGER);
        }
    }

    private static void validateNegativeNumber(int attemptNumber) {
        if (attemptNumber < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NEGATIVE_NUMBER);
        }
    }
}
