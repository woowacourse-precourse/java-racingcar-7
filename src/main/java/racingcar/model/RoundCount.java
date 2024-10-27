package racingcar.model;

import java.util.regex.Pattern;
import racingcar.ErrorMessage;

public class RoundCount {
    private static Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private final int roundCount;

    public RoundCount(String roundCount) {
        validateRoundCount(roundCount);
        this.roundCount = Integer.parseInt(roundCount);
    }

    private void validateRoundCount(String input) {
        validateNumberFormat(input);
        validatePositiveRoundCount(input);
    }

    private void validateNumberFormat(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
        }
    }

    private void validatePositiveRoundCount(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_COUNT_OUT_OF_RANGE.getMessage());
        }
    }
}