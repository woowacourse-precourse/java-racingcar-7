package racingcar.model;

import java.util.regex.Pattern;
import racingcar.view.ErrorMessage;

public class RoundCount {
    private static final int ZERO = 0;
    private static final Pattern NUMBER_REGEX = Pattern.compile("^-?[0-9]+$");
    private int roundCount;

    public RoundCount(String roundCount) {
        validate(roundCount);
        this.roundCount = Integer.parseInt(roundCount);
    }

    public void decrease() {
        if (roundCount <= ZERO) {
            throw new IllegalStateException(ErrorMessage.NO_MORE_ROUND.getMessage());
        }
        roundCount--;
    }

    public boolean hasRemainingRound() {
        return roundCount > ZERO;
    }

    private void validate(String input) {
        validateNumberFormat(input);
        validatePositiveRoundCount(input);
    }

    private void validateNumberFormat(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
        }
    }

    private void validatePositiveRoundCount(String input) {
        if (Integer.parseInt(input) <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_COUNT_OUT_OF_RANGE.getMessage());
        }
    }
}