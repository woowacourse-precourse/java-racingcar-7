package racingcar.util;

import java.util.List;

import static racingcar.util.Constants.MAX_NAME_LENGTH;

public class PlayerNameValidator {

    public void validateName(List<String> names){
        validateBlank(names);
        validateLength(names);
    }

    private void validateBlank(List<String> names){
        for(String name : names){
            if(name.isEmpty() || name.isBlank())
                throw new IllegalArgumentException();
        }
    }
    private void validateLength(List<String> names){
        for(String name : names){
            if(name.length() > MAX_NAME_LENGTH)
                throw new IllegalArgumentException();
        }
    }
}
