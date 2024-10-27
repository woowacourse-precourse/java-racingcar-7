package racingcar.utils;

import static racingcar.constant.ExecptionMessage.INPUT_ROUND_COUNT_TYPE_MESSAGE;
import static racingcar.constant.ExecptionMessage.INPUT_NULL_OR_EMPTY_MESSAGE;

import java.util.regex.Pattern;
import racingcar.exception.NullInputException;
import racingcar.exception.RoundCountTypeException;

public class InputValidator {
    private static final String NUMBER_REGEX = "^[1-9][0-9]*$";

    public static void validateNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new RoundCountTypeException(INPUT_ROUND_COUNT_TYPE_MESSAGE.getMessage());
        }
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new NullInputException(INPUT_NULL_OR_EMPTY_MESSAGE.getMessage());
        }
    }
}
