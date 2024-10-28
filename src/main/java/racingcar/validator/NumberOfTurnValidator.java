package racingcar.validator;

import racingcar.enums.Exceptions;

public class NumberOfTurnValidator {
    public void validateNumberOfTurn(String input) {
        validateNotBlank(input);
        validateNumeric(input);
    }
    private void validateNotBlank(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT_BLANK.getMessage());
        }
    }
    private void validateNumeric(String input) {
        String regex = "^[1-9]\\d*$";
        if(!input.matches(regex)){
            throw new IllegalArgumentException(Exceptions.INVALID_TURN_NUMERIC.getMessage());
        }
    }
}
