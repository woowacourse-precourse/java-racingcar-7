package racingcar.exception;

import java.util.List;

public class Validator {

    public static void checkNameLen(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    public static void checkCarCount(List<String> carNames) {
        if (carNames.isEmpty())
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT);
    }

    public static void isRightNumber(String number) {
        if (!number.matches("\\d+"))
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE_NUMBER);
        try {
            Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_OVER_RANGE);
        }
    }
}
