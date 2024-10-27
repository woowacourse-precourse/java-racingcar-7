package racingcar.util;

import java.util.List;

import static racingcar.util.Constants.MAX_NAME_LENGTH;
import static racingcar.util.ErrorMessages.ERROR_EMPTY_NAME;
import static racingcar.util.ErrorMessages.ERROR_LENGTH_LIMIT_NAME;

public class PlayerNameValidator {

    public void validateName(List<String> names){
        validateBlank(names);
        validateLength(names);
    }

    private void validateBlank(List<String> names){
        for(String name : names){
            if(name.isEmpty() || name.isBlank())
                throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }
    private void validateLength(List<String> names){
        for(String name : names){
            if(name.length() > MAX_NAME_LENGTH)
                throw new IllegalArgumentException(ERROR_LENGTH_LIMIT_NAME);
        }
    }
}
