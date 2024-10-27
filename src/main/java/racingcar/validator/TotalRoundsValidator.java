package racingcar.validator;

import static racingcar.exception.ErrorMessage.EMPTY_INPUT;
import static racingcar.exception.ErrorMessage.NOT_NUMBER;
import static racingcar.exception.ErrorMessage.NOT_INT;
import static racingcar.exception.ErrorMessage.NOT_POSITIVE_INT;

public class TotalRoundsValidator {

    public static void validate(String rawTotalRounds) {
        validateNotEmpty(rawTotalRounds);
        validateIsNumber(rawTotalRounds);
        validateIsInteger(rawTotalRounds);
        validateIstPositiveInteger(rawTotalRounds);

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
    private static void validateIstPositiveInteger (String rawTotalRounds){
        if ( Integer.parseInt(rawTotalRounds) <= 0 ) {
            throw new IllegalArgumentException(NOT_POSITIVE_INT.getMessage());
        }
    }


}
