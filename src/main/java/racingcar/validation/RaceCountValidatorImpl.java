package racingcar.validation;

import static racingcar.validation.ValidatorUtil.isEmptyInput;
import static racingcar.validation.ValidatorUtil.isNumeric;

public class RaceCountValidatorImpl implements RaceCountValidator {

    @Override
    public void validate(String input) {
        validateEmptyOrBlankInput(input);
        validateNumericInput(input);
        validateMinimumAttemptCount(input);
    }

    private void validateEmptyOrBlankInput(String raceCount) {
        if (isEmptyInput(raceCount)) {
            throw new IllegalArgumentException("경주 횟수는 빈 값이나 공백일 수 없습니다.");
        }
    }

    private void validateNumericInput(String raceCount) {
        if (isNumeric(raceCount)) {
            throw new IllegalArgumentException("경주 횟수는 숫자여야 합니다.");
        }
    }

    private void validateMinimumAttemptCount(String raceCountInput) {
        int raceCount = Integer.parseInt(raceCountInput);
        if (raceCount <= 0) {
            throw new IllegalArgumentException("경주 횟수는 1 이상이어야 합니다.");
        }
    }
}
