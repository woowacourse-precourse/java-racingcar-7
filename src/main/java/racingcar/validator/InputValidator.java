package racingcar.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String CAR_NAME_REGEX = "^[a-zA-Z]{1,5}$"; // 1-5자 알파벳

    public static void validateCarNames(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }

        for (String name : carNames) {
            validateCarName(name);
        }
    }

    private static void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }

        if (!Pattern.matches(CAR_NAME_REGEX, name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 알파벳이어야 합니다.");
        }
    }

    public static void validateAttempts(String attemptsInput) {
        if (attemptsInput == null || attemptsInput.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }

        if (!Pattern.matches("^[0-9]+$", attemptsInput)) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }

        int attempts = Integer.parseInt(attemptsInput);
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}