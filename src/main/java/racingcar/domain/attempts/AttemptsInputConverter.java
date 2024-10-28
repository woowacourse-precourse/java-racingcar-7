package racingcar.domain.attempts;

public class AttemptsInputConverter {
    private static final int MIN_ATTEMPTS = 1;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE =
            "유효하지 않은 입력값 입니다. 시도 횟수는 1이상 정수만 입력 가능합니다. 입력값: ";

    private AttemptsInputConverter() {
    }

    public static int convert(String input) {
        int attempts = parseInt(input);
        validate(attempts);
        return attempts;
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE + str);
        }
    }

    private static void validate(int value) {
        if (value < MIN_ATTEMPTS) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE + value);
        }
    }
}
