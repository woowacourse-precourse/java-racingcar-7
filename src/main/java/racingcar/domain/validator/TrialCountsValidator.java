package racingcar.domain.validator;

public class TrialCountsValidator {

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
            throw new IllegalArgumentException("입력한 값은 숫자가 아닙니다 : " + trialCounts);
        }
        return tempCounts;
    }

    private void validateIsZero(int counts) {
        if(counts <= 0) {
            throw new IllegalArgumentException("입력한 값은 0보다 커야 합니다 : " + counts);
        }
    }
}
