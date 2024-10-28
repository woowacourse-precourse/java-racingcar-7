package racingcar.validation;

import racingcar.error.ErrorMessage;

public class TrialTimesValidator {
    private TrialTimesValidator() {}

    public static void validate(String trialTimes) {
        try {
            Integer.parseInt(trialTimes);
            checkNegativeNumber(trialTimes);
        } catch (NumberFormatException e) {
            ErrorMessage.printTrialTimeIsNotNumberError();
            throw new IllegalArgumentException();
        }
    }

    private static void checkNegativeNumber(String trialTimes) {
        if(Integer.parseInt(trialTimes) < 0) {
            ErrorMessage.printTrialTimeIsNegaviveNumberError();
            throw new IllegalArgumentException();
        }
    }
}
