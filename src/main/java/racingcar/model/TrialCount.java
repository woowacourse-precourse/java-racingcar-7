package racingcar.model;

import static racingcar.common.exception.ErrorMessage.TRIAL_COUNT_TYPE_ERROR;
import static racingcar.common.exception.ErrorMessage.TRIAL_COUNT_ZERO_OR_NEGATIVE_VALUE_ERROR;

import java.util.Objects;

public record TrialCount(Integer number) {

    public TrialCount {
        Objects.requireNonNull(number);
        Validator.validatePositive(number);
    }

    public static TrialCount from(String trialCount) {
        return new TrialCount(Validator.validate(trialCount));
    }

    private static class Validator {
        private static int validate(String trialCount) {
            int number = validateInteger(trialCount);
            validatePositive(number);
            return number;
        }

        private static int validateInteger(String number) {
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(TRIAL_COUNT_TYPE_ERROR);
            }
        }

        private static void validatePositive(int number) {
            if (number < 1) {
                throw new IllegalArgumentException(TRIAL_COUNT_ZERO_OR_NEGATIVE_VALUE_ERROR);
            }
        }
    }
}
