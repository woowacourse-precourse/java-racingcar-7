package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ATTEMPT_COUNT = 0;
    private static final String NUMERIC_REGEX = "-?\\d+";

    public static void isEmpty(String name) {
        if (isNull(name) || isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름에 빈칸은 입력할수 없습니다");
        }
    }

    public static void isCarNameRange(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다");
        }
    }

    public static void containDuplicate(List<String> names) {
        Set<String> uniqueCars = new HashSet<>(names);
        if (uniqueCars.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될수 없습니다.");
        }
    }

    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될수 없습니다");
        }
    }

    public static void validateNumericInput(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력가능합니다");
        }
    }

    private static boolean isNull(String name) {
        return name == null;
    }

    private static boolean isBlank(String name) {
        return name.trim().isBlank();
    }

}
