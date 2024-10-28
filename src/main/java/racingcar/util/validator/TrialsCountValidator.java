package racingcar.util.validator;

import java.util.regex.Pattern;
import racingcar.util.ExceptionMessage;
import racingcar.util.Util;

public class TrialsCountValidator extends Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private static final int MIN_TRIAL_RANGE = 1;
    private static final int MAX_TRIAL_RANGE = 1000;


    @Override
    public void validate(String input) throws IllegalArgumentException {
        String trimmedInput = Util.removeSpace(input);
        validateNumeric(trimmedInput);
        validateTrialInputRange(trimmedInput);
    }

    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
        }
    }

    void validateTrialInputRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_TRIAL_RANGE || number > MAX_TRIAL_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INPUT_BOUND.getMessage());
        }
    }
}
