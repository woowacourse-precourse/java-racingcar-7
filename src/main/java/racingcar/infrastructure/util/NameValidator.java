package racingcar.infrastructure.util;

import racingcar.presentation.enums.ExceptionMessage;

import java.util.List;

public class NameValidator {

    public static void validRacingCarName(List<String> names){
        for(String carName : names){
            if(carName.length() > 5){
                throw new IllegalArgumentException(ExceptionMessage.OVER_5_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    public static int validNumber(String number){
        try{
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_NUMBER.getMessage());
        }
    }
}
