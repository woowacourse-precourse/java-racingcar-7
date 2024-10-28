package racingcar.domain;

import static racingcar.constants.CarRaceConstants.MIN_TRIAL_COUNT;
import static racingcar.exception.Exception.TRIAL_COUNT_NOT_A_NUMBER;
import static racingcar.exception.Exception.TRIAL_COUNT_TOO_LARGE;
import static racingcar.exception.Exception.TRIAL_COUNT_TOO_SMALL;

import java.math.BigInteger;

public class TrialCountValidator {
    private static final BigInteger MAX_INT_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);

    public static void validate(String trialCountInput) {
        validateNumberFormat(trialCountInput);
        validateTrialCountSize(trialCountInput);
        validatePositiveInteger(trialCountInput);
    }

    private static void validateNumberFormat(String trialCountInput) {
        if (!trialCountInput.matches("\\d+")) {
            throw new IllegalArgumentException(TRIAL_COUNT_NOT_A_NUMBER.getMessage());
        }
    }

    private static void validateTrialCountSize(String trialCountInput) {
        BigInteger trialCountBigInt = new BigInteger(trialCountInput);
        if (trialCountBigInt.compareTo(MAX_INT_VALUE) > 0) {
            throw new IllegalArgumentException(TRIAL_COUNT_TOO_LARGE.getMessage());
        }
    }

    private static void validatePositiveInteger(String trialCountInput) {
        int trialCountInt = Integer.parseInt(trialCountInput);
        if (trialCountInt < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException(TRIAL_COUNT_TOO_SMALL.getMessage());
        }
    }
}
