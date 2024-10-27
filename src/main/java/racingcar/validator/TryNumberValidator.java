package racingcar.validator;

import racingcar.exception.CustomException;
import racingcar.exception.ErrorMessage;

public class TryNumberValidator {

    public void validateTryNumber(String tryNumber) {

        if (tryNumber == null || tryNumber.isEmpty()) {
            throw new CustomException(ErrorMessage.EMPTY_TRY_NUMBER);
        }
        if (tryNumber.equals("0")) {
            throw new CustomException(ErrorMessage.ZERO_TRY_NUMBER);
        }
        if (tryNumber.matches("-\\d+")) {
            throw new CustomException(ErrorMessage.NEGATIVE_PATTERN);
        }

        try {
            Integer.parseInt(tryNumber);
        } catch (Exception e) {
            throw new CustomException(ErrorMessage.WRONG_NUMBER_FORMAT);
        }
    }
}
