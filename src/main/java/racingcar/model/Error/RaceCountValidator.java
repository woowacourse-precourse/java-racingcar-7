package racingcar.model.Error;

import static racingcar.model.Error.ErrorMessage.*;

public class RaceCountValidator extends Validator {

    public int validateRaceNum (String input) {
        validateInputMustHaveValue(input);
        int raceNum = validateInputParseToInteger(input);
        validateInputIsNotMinus(raceNum);
        return raceNum;
    }

    @Override
    protected void validateInputMustHaveValue(Object input) {
        if (!(input instanceof String)) {
            throw new IllegalArgumentException(NotValidType);
        }

        String strInput = (String) input;
        if (strInput.isBlank()) {
            throw new IllegalArgumentException(InputMustHaveValue);
        }
    }

    private int validateInputParseToInteger(String input){
        int raceNum;

        try{
            raceNum = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IsNotNumber);
        }

        return raceNum;
    }

    private void validateInputIsNotMinus(int input) {
        if(input<0) {
            throw new IllegalArgumentException(RaceNumIsMinus);
        }
    }
}
