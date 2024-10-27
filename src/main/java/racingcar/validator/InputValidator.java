package racingcar.validator;

import java.util.Arrays;

public class InputValidator {

    public boolean isInputEmpty(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isBlank()) {
            return true;
        }
        return false;
    }

    public boolean validCarNameLength(String[] carNames) {
        return Arrays.stream(carNames)
                .allMatch(c -> c.length() <= 5);
    }

    public int getValidatedRacingAttempt(String inputRacingAttempt) {
        try {
            int attempt = convertToInteger(inputRacingAttempt);
            isRacingAttemptPositive(attempt);
            return attempt;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("1이상의 양수를 입력해주세요.");
        }
    }

    private void isRacingAttemptPositive(int inputRacingAttempt) {
        if (inputRacingAttempt <= 0) {
            throw new RuntimeException();
        }
    }

    private int convertToInteger(String inputRacingAttempt) {
        try {
            return Integer.parseInt(inputRacingAttempt);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
