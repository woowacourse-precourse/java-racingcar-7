package racingcar.validation;

import racingcar.enums.ErrorMessage;
import racingcar.enums.RegexPattern;

public class TryCountValidator {
    public static void validate(String input) {
        validateNull(input);
        validateNotNum(input);
        validateTryCountRange(input);

    }

    private static void validateTryCountRange(String input) {
        int tryCount = Integer.parseInt(input);
        if (tryCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_UNDER_ONE.getMessage());
        }
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_TRY_COUNT_BLANK.getMessage());
        }
    }

    private static void validateNotNum(String input) {
        if (RegexPattern.NO_CONTAIN_NUMBER.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_TRY_COUNT_WITHOUT_NUM.getMessage());
        }
    }
}
