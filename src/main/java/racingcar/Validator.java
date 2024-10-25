package racingcar;

import java.util.HashSet;
import java.util.Set;

public final class Validator {
    private Validator() {
    } // Util Class

    public static void validateCarNames(final String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("적어도 한 대의 자동차 이름을 입력해야 합니다.");
        }

        final Set<String> uniqueNames = new HashSet<>(); // 중복 체크용 Set
        for (final String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
            }
            if (hasSameCarNames(uniqueNames, name)) {
                throw new IllegalArgumentException("자동차 이름에 중복이 존재합니다: " + name);
            }
        }
    }

    private static boolean hasSameCarNames(final Set<String> uniqueNames, final String name) {
        final String lowerCaseName = name.toLowerCase();

        return !uniqueNames.add(lowerCaseName); // 같은 이름이 존재하면
    }

    public static void validateAttempts(final int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다: " + attempts);
        }
    }
}
