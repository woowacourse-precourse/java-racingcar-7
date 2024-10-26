package racingcar.validator;

import racingcar.constant.ErrorMessage;

public class CarValidator {
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private CarValidator() {}

    public static void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MAX_LENGTH_IS_FIVE);
        } // end if
    } // validateCarName
} // class