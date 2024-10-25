package racingcar.util;

import static racingcar.constant.ErrorMessage.CARNAME_BLANK_EXCEPTION;
import static racingcar.constant.ErrorMessage.CARNAME_LENGTH_EXCEPTION;

public class Validator {

    public void checkCarNameInput(String input){
        String[] carNames = input.split(",");
        for(String carName : carNames){
            if(carName.isEmpty()){
                throw new IllegalArgumentException(CARNAME_BLANK_EXCEPTION.getMessage());
            }
            if(carName.length() > 5){
                throw new IllegalArgumentException(String.format(CARNAME_LENGTH_EXCEPTION.getMessage(), carName));
            }
        }
    }


}
