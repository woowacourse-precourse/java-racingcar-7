package racingcar.exception;

import java.util.List;

public class InputValidator {

    private static final int NAME_LEN_LIMIT = 5;

    public static void checkNameLen(final String name) {
        if (name.length() > NAME_LEN_LIMIT)
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    public static void checkCarCount(final List<String> carNames) {
        if (carNames.isEmpty())
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT);
    }

    public static void isRightNumber(final String number) {
        if (!number.matches("\\d+"))
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE_NUMBER);
        try {
            Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_OVER_RANGE);
        }
    }
}
