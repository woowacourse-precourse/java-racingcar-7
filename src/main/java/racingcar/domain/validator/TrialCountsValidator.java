package racingcar.domain.validator;

public class TrialCountsValidator {
    private final static String EXCEPTION_MESSAGE_NOT_NUMBER = "숫자가 아닌 값을 입력하시면 안 됩니다.";
    private final static String EXCEPTION_MESSAGE_NOT_MINUS_NUMBER = "음수와 0을 입력하시면 안 됩니다.";

    public int validate(String trialCounts) {
        int counts = validateIsNumber(trialCounts);
        validateIsZero(counts);
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

    private void validateIsZero(int counts) {
        if (counts <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_MINUS_NUMBER);
        }
    }
}
