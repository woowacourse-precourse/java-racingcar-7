package racingcar.exception;

import racingcar.message.ExceptionMessage;

public class InputExceptionHandler {

    public static void validateCarName(String[] names) {
        for (String carName : names) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }
}
