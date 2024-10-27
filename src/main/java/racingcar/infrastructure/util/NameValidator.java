package racingcar.infrastructure.util;

import racingcar.presentation.enums.ExceptionMessage;

import java.util.List;

public class NameValidator {

    public void validRacingCarName(List<String> names){
        for(String carName : names){
            if(carName.length() > 5){
                throw new IllegalArgumentException(ExceptionMessage.OVER_5_CAR_NAME_LENGTH.getMessage());
            }
        }
    }
}
