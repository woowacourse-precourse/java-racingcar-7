package racingcar;

import java.util.regex.Pattern;

public class InputValidator {
    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5 || name.trim().isEmpty() || !Pattern.matches("^[a-zA-Z]+$", name)) {
                throw new IllegalArgumentException("잘못된 자동차 이름입니다. 자동차 이름은 5자 이하의 알파벳이어야 합니다.");
            }
        }
    }

    public static void validateAttempts(String attemptsInput) {
        if (!Pattern.matches("^[0-9]+$", attemptsInput) || Integer.parseInt(attemptsInput) <= 0) {
            throw new IllegalArgumentException("잘못된 시도 횟수입니다. 양의 정수를 입력하세요.");
        }
    }
}
