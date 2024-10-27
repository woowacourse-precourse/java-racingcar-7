package racingcar.domain.validator;

public class TrialCountsValidator {
    private final static String EXCEPTION_MESSAGE_NOT_NUMBER = "숫자가 아닌 값을 입력하시면 안 됩니다.";
    private final static String EXCEPTION_MESSAGE_NOT_MINUS_NUMBER = "음수와 0을 입력하시면 안 됩니다.";
    private final static String EXCEPTION_MESSAGE_OVERFLOW = "시도 횟수는 1~100사이의 숫자를 입력하셔야 합니다.";
    private final static int TRIAL_COUNTS_MAXIMUM = 100;
    private final static int TRIAL_COUNTS_MINIMUM = 1;

    public int validate(String trialCounts) {
        int counts = validateIsNumber(trialCounts);
        validateRange(counts);
        return counts;
    }

    private int validateIsNumber(String trialCounts) {
        int tempCounts;
        try {
            tempCounts = Integer.parseInt(trialCounts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_NUMBER);
        }
        return tempCounts;
    }

    private void validateRange(int counts) {
        if (counts < TRIAL_COUNTS_MINIMUM) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_MINUS_NUMBER);
        }
        if (counts > TRIAL_COUNTS_MAXIMUM) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OVERFLOW);
        }
    }
}
