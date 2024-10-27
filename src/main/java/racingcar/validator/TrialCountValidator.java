package racingcar.validator;

import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

/**
 * TrialCountValidator
 * - 시도 횟수 유효성 검사
 */
public class TrialCountValidator {

    public static void validate(int trialCount) {
        if (trialCount < 1) {
            throw new CarRacingException(ErrorMessage.INVALID_TRIAL_COUNT);
        }
    }
}
