package racingcar.validator;

import static racingcar.exception.ErrorMessage.EMPTY_INPUT;
import static racingcar.exception.ErrorMessage.NOT_NUMBER;
import static racingcar.exception.ErrorMessage.NOT_INT;

public class TrialNumberValidator {

    public static void validate(String rawTrialNumber) {
        validateNotEmpty(rawTrialNumber);
        validateIsNumber(rawTrialNumber);
        validateIsInteger(rawTrialNumber);

    }

    private static void validateNotEmpty (String rawTrialNumber){
        if( rawTrialNumber.isEmpty() ){
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void validateIsNumber (String rawTrialNumber){
        try {
            Float.parseFloat(rawTrialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private static void validateIsInteger (String rawTrialNumber){
        try {
            Integer.parseInt(rawTrialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INT.getMessage());
        }
    }


}
