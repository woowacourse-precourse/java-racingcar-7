package racingcar.validator;

import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

/**
 * TrialCountValidator
 * - 시도 횟수 유효성 검사
 */
public class TrialCountValidator {

    public static void validate(String trialCountInput) {
        try {
            int trialCount = Integer.parseInt(trialCountInput);
            if (trialCount < 1) {
                throw new CarRacingException(ErrorMessage.INVALID_TRIAL_COUNT);
            }
        } catch (NumberFormatException e) {
            throw new CarRacingException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
