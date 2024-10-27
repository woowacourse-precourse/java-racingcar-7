package racingcar.validator;

import static racingcar.exception.ErrorMessage.EMPTY_INPUT;
import static racingcar.exception.ErrorMessage.NOT_NUMBER;
import static racingcar.exception.ErrorMessage.NOT_INT;

public class TotalRoundsValidator {

    public static void validate(String rawTotalRounds) {
        validateNotEmpty(rawTotalRounds);
        validateIsNumber(rawTotalRounds);
        validateIsInteger(rawTotalRounds);

    }

    private static void validateNotEmpty (String rawTotalRounds){
        if( rawTotalRounds.isEmpty() ){
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void validateIsNumber (String rawTotalRounds){
        try {
            Float.parseFloat(rawTotalRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private static void validateIsInteger (String rawTotalRounds){
        try {
            Integer.parseInt(rawTotalRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INT.getMessage());
        }
    }


}
