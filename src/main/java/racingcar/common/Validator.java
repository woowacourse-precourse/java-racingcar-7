package racingcar.common;

import static racingcar.common.ErrorMessage.TOO_LONG_CAR_NAME;

public class Validator {

    public static void validateCarNameLength(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME.getMessage());
        }
    }
}
