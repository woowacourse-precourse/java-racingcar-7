package racingcar.validator;

import racingcar.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    public static void validateNumber(String input) {
        String regexp = "^\\d*$";
        if (!Pattern.matches(regexp, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
