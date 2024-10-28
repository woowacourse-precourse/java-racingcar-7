package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateCarNames(String[] names) {
        validateCarCount(names);
        validateEachCarName(names);
    }

    private static void validateCarCount(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("최소 2대 이상의 자동차 이름을 입력해야 합니다.");
        }
    }

    private static void validateEachCarName(String[] names) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            String trimmedName = name.trim();

            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }

            if (!uniqueNames.add(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + trimmedName);
            }
        }
    }

    public static int validateAttemptCount(String attemptCount) {
        try {
            int validAttemptCount = Integer.parseInt(attemptCount);

            if (validAttemptCount < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            return validAttemptCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }
}