package racingcar;

import java.util.HashSet;
import java.util.Set;

public final class CarValidator {

    private CarValidator() {
    }

    public static void name(final String name) {
        validateNameIsBlank(name);
        validateNameLength(name);
    }

    private static void validateNameIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    private static void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static void validateDuplicateCarName(final String[] carNames) {
        Set<String> existingCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (!existingCarNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
