package racingcar.domain;

public class TrialCount {
    private final int trialCount;

    public TrialCount(final String trialCount) {
        validateMovingCountIsNatural(trialCount);
        this.trialCount = convertStringToInt(trialCount);
    }

    private void validateMovingCountIsNatural(String trialCount) {
        if (!trialCount.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException("이동할 횟수는 자연수여야 합니다.");
        }
    }
    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public int getTrialCount() {
        return trialCount;
    }
}
