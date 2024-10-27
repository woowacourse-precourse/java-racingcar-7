package racingcar.validator;

import java.util.Arrays;

public class InputValidator {

    public void isInputEmpty(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력해주세요.");
        }
    }

    public void validCarNameLength(String[] carNames) {
        boolean result = Arrays.stream(carNames)
                .allMatch(c -> c.length() <= 5);

        if (!result) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
        }
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
