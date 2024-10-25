package racingcar.validator;

import java.util.List;

public class InputValidator {
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_ATTEMPTS = 1;

    public void isStringNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public void validateCarNames(List<String> carNames) {
        carNames.stream().filter(name -> name.length() > MAX_CAR_NAME).forEach(name -> {
            throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
        });
    }

    public void validateAttempts(int attempts) {
        if (attempts <= MIN_ATTEMPTS) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }
    }
}
