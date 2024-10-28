package racingcar.validation;

import racingcar.error.ErrorMessage;
import racingcar.util.DataTransFormer;

public class TrialTimesValidator {
    private TrialTimesValidator() {
    }

    public static void validate(String trialTimes) {
        try {
            DataTransFormer.makeStringToInt(trialTimes);
            checkNegativeNumber(trialTimes);
        } catch (NumberFormatException e) {
            ErrorMessage.printTrialTimeIsNotNumberError();
            throw new IllegalArgumentException();
        }
    }

    private static void checkNegativeNumber(String trialTimes) {
        if (DataTransFormer.makeStringToInt(trialTimes) < 0) {
            ErrorMessage.printTrialTimeIsNegaviveNumberError();
            throw new IllegalArgumentException();
        }
    }
}
