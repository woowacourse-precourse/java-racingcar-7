package racingcar.validation;

import java.util.regex.Pattern;
import racingcar.enums.ErrorMessage;

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
        if (Pattern.compile(".*[\\D].*").matcher(input).find()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_TRY_COUNT_WITHOUT_NUM.getMessage());
        }
    }
}
