package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        checkForEmptyNames(carNames);
        checkForNameLength(carNames);
        checkForDuplicateNames(carNames);
    }

    private static void checkForEmptyNames(List<String> carNames) {
        for (String name : carNames) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 공백이거나 입력되지 않았습니다.");
            }
        }
    }

    private static void checkForNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다:" + name);
            }
        }
    }

    private static void checkForDuplicateNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 존재합니다.");
        }
    }

    public static void validateAttempt(String attemptInput) {
        try {
            int attempts = Integer.parseInt(attemptInput);
            if (attempts < 0) {
                throw new IllegalArgumentException("이동 횟수는 음수가 될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }
}
