package racingcar.validator;

import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

public class NumberInputValidator {

    public static void validate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionCode.WRONG_NUMBER_FORMAT);
        }
    }
}
