package racingcar.validation;

import static racingcar.validation.ValidatorUtil.isEmptyInput;
import static racingcar.validation.ValidatorUtil.isNumeric;

public class AttemptCountValidatorImpl implements AttemptCountValidator {

    @Override
    public void validate(String input) {
        validateEmptyOrBlankInput(input);
        validateNumericInput(input);
        validateMinimumAttemptCount(input);
    }

    private void validateEmptyOrBlankInput(String attemptCount) {
        if (isEmptyInput(attemptCount)) {
            throw new IllegalArgumentException("경주 횟수는 빈 값이나 공백일 수 없습니다.");
        }
    }

    private void validateNumericInput(String attemptCount) {
        if (isNumeric(attemptCount)) {
            throw new IllegalArgumentException("경주 횟수는 숫자여야 합니다.");
        }
    }

    private void validateMinimumAttemptCount(String attemptCountInput) {
        int attemptCount = Integer.parseInt(attemptCountInput);
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("경주 횟수는 1 이상이어야 합니다.");
        }
    }
}
