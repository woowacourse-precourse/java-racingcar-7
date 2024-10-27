package racingcar.util.validator;

public class TryCountValidator {

    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 100;
    private static final String INVALID_TRY_COUNT_INPUT_MESSAGE = "시도 횟수를 잘못 입력하셨습니다.";
    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 최소 1번, 최대 100번까지 가능합니다.";

    public static void validate(String tryCount) {
        int count = parse(tryCount);
        validateTryCountRange(count);
    }

    private static int parse(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_INPUT_MESSAGE);
        }
    }

    private static void validateTryCountRange(int count) {
        if (count < MIN_TRY_COUNT || count > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }
}
