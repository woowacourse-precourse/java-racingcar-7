package racingcar.validator;

import static racingcar.constants.Constants.*;

public class RoundValidator {

    private final int round;

    public RoundValidator(String round) {
        this.round = parseInt(round);
    }

    public void verify() {
        positiveNumber(round);
    }

    private int parseInt(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_NUMBER_WRONG_ERROR);
        }
    }

    private void positiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ROUND_NUMBER_WRONG_ERROR);
        }
    }

    public int getRound() {
        return round;
    }
}
