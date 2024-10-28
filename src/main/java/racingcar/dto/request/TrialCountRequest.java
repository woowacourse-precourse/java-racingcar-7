package racingcar.dto.request;

import racingcar.domain.TrialCount;

import static racingcar.exception.ExceptionMessage.WRONG_TRIAL_COUNT_FORMAT;

public record TrialCountRequest(
        String trialCount
) {
    public TrialCountRequest{
        validateNumber(trialCount);
    }

    public TrialCount toTrialCount() {
        int count = Integer.parseInt(trialCount);
        return new TrialCount(count);
    }

    private void validateNumber(String trialCount) {
        try {
            Integer.parseInt(trialCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_TRIAL_COUNT_FORMAT.getMessage());
        }
    }
}
