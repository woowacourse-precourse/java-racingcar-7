package racingcar.validator;

import static racingcar.Constatns.TRIAL_COUNT_CONDITION_ERROR_MESSAGE;

public class TrialCountValidator {
    public static void trialCountValidator(int trialCount){
        if(trialCount<1){
            throw new IllegalArgumentException(TRIAL_COUNT_CONDITION_ERROR_MESSAGE);
        }
    }
}
