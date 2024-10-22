package racingcar.validation;

import racingcar.exception.CustomException;
import racingcar.message.ErrorMessage;

public class Validator {

    public static void checkNameLength(String car){
        if(car.length() > 5){
            throw new CustomException(ErrorMessage.INVALID_NAME_LENGTH);
        }
    }

    public static int checkIfNumber(String number){
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new CustomException(ErrorMessage.INVALID_NUMBER);
        }
    }
}
