package racingcar.util;

import java.util.regex.Pattern;

import static racingcar.constant.ErrorMessage.*;

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

    public void checkAttemptInput(String input) {
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ATTEMPTS_FORMAT_EXCEPTION.getMessage() + input);
        }
    }
}
