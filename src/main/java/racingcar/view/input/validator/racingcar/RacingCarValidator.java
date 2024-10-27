package racingcar.view.input.validator.racingcar;

import racingcar.constant.errormessage.ErrorMessage;
import racingcar.regex.domain.RegexPattern;

public class RacingCarValidator {
    public static void validator(String input) {
        regexPatternValidator(input);

    }
    private static void regexPatternValidator(String input) {
        if (!RegexPattern.CAR_INPUT_REGEX_PATTERN.match(input)) throw new IllegalArgumentException(ErrorMessage.REGEX_ERROR);
    }
}
