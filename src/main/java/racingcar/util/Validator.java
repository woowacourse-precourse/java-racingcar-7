package racingcar.util;

import java.util.List;
import racingcar.exception.CustomException;
import racingcar.exception.ErrorCode;

public class Validator {

    public static void validateTryCountInteger(String input) {
        if (!input.matches("[1-9]\\d*")) {
            throw new CustomException(ErrorCode.INVALID_TRY_COUNT_TYPE);
        }
    }

    public static void validateCarNameLength(List<String> input) {
        for (String carName : input) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new CustomException(ErrorCode.INVALID_CAR_NAME_LENGTH);
            }
        }
    }

    public static void validateCarNameType(List<String> input) {
        for (String carName : input) {
            if (!carName.matches("[a-zA-Z]+")) {
                throw new CustomException(ErrorCode.INVALID_INPUT_TYPE);
            }
        }
    }

    public static void validateInput(List<String> carNames, String tryCountInput) {
        validateCarNameType(carNames);
        validateCarNameLength(carNames);
        validateTryCountInteger(tryCountInput);
    }
}
