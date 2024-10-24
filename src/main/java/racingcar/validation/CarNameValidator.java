package racingcar.validation;

import java.util.regex.Pattern;
import racingcar.enums.ErrorMessage;

public class CarNameValidator {

    public static void validate(String input) {
        validateSeparatorWithoutComma(input);
        validateStartWithComma(input);
    }

    private static void validateSeparatorWithoutComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }

    private static void validateStartWithComma(String input) {
        if (Pattern.compile("^,").matcher(input).find()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_FRONT_COMMA.getMessage());
        }
    }

    public static void validateCar(String input) {

    }
}
