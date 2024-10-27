package racingcar.util.validator;

import racingcar.util.Util;

public class TrialsCountValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        String trimmedInput = Util.removeSpace(input);
        validateNumeric(trimmedInput);
        validateTrialInputRange(trimmedInput);
    }
}
