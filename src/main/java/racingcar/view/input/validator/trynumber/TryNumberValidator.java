package racingcar.view.input.validator.trynumber;

import racingcar.constant.errormessage.ErrorMessage;
import racingcar.regex.domain.RegexPattern;

import java.math.BigInteger;

public class TryNumberValidator {
    public static void validator(String input) {
        isBlankValidator(input);
        isNoneZeroOnlyNumberValidator(input);
        maxIntegerValueValidator(input);
    }
    private static void isBlankValidator(String input) {
        if (input.isBlank()) throw new IllegalArgumentException(ErrorMessage.REGEX_ERROR);
    }
    private static void isNoneZeroOnlyNumberValidator(String input) {
        if (!RegexPattern.TRY_NUMBER_INPUT_REGEX_PATTERN.match(input)) throw new IllegalArgumentException(ErrorMessage.REGEX_ERROR);
    }
    private static void maxIntegerValueValidator(String input) {
        BigInteger bigInteger = new BigInteger(input);
        try {
            bigInteger.intValueExact();
        }
        catch (ArithmeticException arithmeticException) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_MAX_VALUE_ERROR);
        }
    }
}
