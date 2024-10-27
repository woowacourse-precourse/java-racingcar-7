package racingcar.Validation;

public class NumberOfTrialValidation {
    public static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isNegative(int trialCount) {
        return trialCount < 0;
    }

    public static boolean isZero(int trialCount) {
        return trialCount == 0;
    }
}
