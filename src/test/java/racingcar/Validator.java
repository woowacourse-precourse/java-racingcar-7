package racingcar;

import java.util.List;

public class Validator {
    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
            }
        }
    }

    static void validateAttemptCount(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시행횟수가 양수가 아닙니다.");
        }
    }
}
