package racingcar.validation;

import racingcar.error.ErrorMessage;

public class TrialTimesValidator {
    private TrialTimesValidator() {}

    public static void validate(String trialTimes) {
        try {
            Integer.parseInt(trialTimes);
        } catch (NumberFormatException e) {
            ErrorMessage.printTrialTimeIsNotNumberError();
            throw new IllegalArgumentException();
        }
    }
}
