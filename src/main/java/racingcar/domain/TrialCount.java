package racingcar.domain;

import static racingcar.util.Message.ErrorMessage.NOT_A_NUMBER_ERROR;
import static racingcar.util.Message.ErrorMessage.TRIAL_MIN_COUNT_ERROR;

public class TrialCount {
    private static final int MIN_TRIAL_COUNT = 1;
    private final int amount;

    public TrialCount(String amount) {
        validateIsNumber(amount);
        int num = Integer.parseInt(amount);
        validateAmountRange(num);
        this.amount = num;
    }

    public int getAmount() {
        return this.amount;
    }

    private void validateIsNumber(final String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR);
        }

    }

    private void validateAmountRange(final int num) {
        if (num < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException(TRIAL_MIN_COUNT_ERROR);
        }
    }
}
