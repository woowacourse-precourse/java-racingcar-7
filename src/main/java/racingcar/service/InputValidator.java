package racingcar.service;

import racingcar.exception.CustomException;
import racingcar.exception.ErrorCode;

public class InputValidator {

    private static final int MINIMUM_CAR_NAME_SIZE = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_TRY_COUNT = 1;

    public void validateCarNames(String[] carNames) {

        if (carNames.length < MINIMUM_CAR_NAME_SIZE) {
            throw new CustomException(ErrorCode.CAR_COUNT_ZERO);
        }

        for (String carName : carNames) {

            int lengthWithoutBlank = carName.replace(" ", "").length();

            if (carName.isBlank()) {
                throw new CustomException(ErrorCode.CAR_NAME_BLANK);
            }
            if (lengthWithoutBlank > MAX_CAR_NAME_LENGTH) {
                throw new CustomException(ErrorCode.CAR_NAME_LENGTH_LONG);
            }
        }
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new CustomException(ErrorCode.TRY_COUNT_INVALID);
        }
    }
}
