package domain;

public class TryCount {

    private static final String TRY_COUNT_NOT_NUMBER_ERROR_MESSAGE = "시도 횟수는 숫자를 입력해야 합니다.";
    private static final String TRY_COUNT_NUMBER_ZERO_ERROR_MESSAGE = "시도 횟수는 0보다 큰 숫자를 입력해야 합니다.";
    private static final String TRY_COUNT_NUMBER_MINUS_ERROR_MESSAGE = "시도 횟수는 양수를 입력해야 합니다.";
    private static final String NUMBER_REGEX = "\\d+";

    private int value;

    public TryCount(final String input) {
        validateTryCountNumber(input);
        validateTryCountZero(input);
        validateTryCountMinusNumber(input);
        this.value = Integer.parseInt(input);
    }

    private static void validateTryCountNumber(final String input) {
        if(!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateTryCountZero(final String input) {
        if(Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ZERO_ERROR_MESSAGE);
        }
    }

    private static void validateTryCountMinusNumber(final String input) {
        if(Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_MINUS_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
