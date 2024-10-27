package racingcar.model.service.validator;

public class RacingcarValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_ROUND = 10000;

    public void validateSplitCarNames(String carNames, String delimiter) {
        if (!carNames.contains(delimiter)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        }
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다: " + carName);
        }
    }

    public void validateAttemptCount(String attemptCountInput) {
        try {
            int attemptCount = Integer.parseInt(attemptCountInput);
            if (attemptCount < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            } else if (attemptCount > MAX_ROUND) {
                throw new IllegalArgumentException("시도 횟수는 " + MAX_ROUND + " 이하이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
