package racingcar.util;

import static racingcar.message.exception.IntConverterExceptionMessage.INPUT_VALUE_INCLUDE_SPECIAL_CHARACTERS;
import static racingcar.message.exception.IntConverterExceptionMessage.INPUT_VALUE_MINUS_OR_ZERO;
import static racingcar.message.exception.IntConverterExceptionMessage.INPUT_VALUE_OVERFLOW;

public class IntConverter {
    private IntConverter() {
    }

    public static long StringToInt(String string) {
        int parsedLong;

        try {
            parsedLong = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            checkNumberFormat(e);
            throw new IllegalArgumentException(INPUT_VALUE_OVERFLOW);
        }

        if (parsedLong <= 0) {
            throw new IllegalArgumentException(INPUT_VALUE_MINUS_OR_ZERO);
        }

        return parsedLong;
    }

    private static void checkNumberFormat(NumberFormatException e) {
        String message = e.getMessage();
        String errorInput = message.substring(message.indexOf(':') + 3, message.length() - 1);

        for (int i = 0; i < errorInput.length(); i++) {
            if (!Character.isDigit(errorInput.charAt(i))) {
                throw new IllegalArgumentException(INPUT_VALUE_INCLUDE_SPECIAL_CHARACTERS);
            }
        }
    }
}
