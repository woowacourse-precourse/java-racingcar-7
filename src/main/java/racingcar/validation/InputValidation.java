package racingcar.validation;

import racingcar.error.ErrorMessage;

public class InputValidation {
    private static final String DELIMITER = ",";

    public static void validateDelimiter(String input){
        if(!input.contains(DELIMITER)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }
}
