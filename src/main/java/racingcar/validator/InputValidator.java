package racingcar.validator;

import java.util.List;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        if (carNames.stream().anyMatch(InputValidator::isInvalidName)) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해 주세요.");
        }
    }

    private static boolean isInvalidName(String name) {
        return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }

    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상의 정수로 입력해 주세요.");
        }
    }
}
