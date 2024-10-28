package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_CAR_COUNT = 100;
    private static final int MAX_TRY_COUNT = 1000;

    private ValidationUtils() {} //인스턴스화 방지

    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차가 한 대 이상 입력되어야 합니다.");
        }
        if (carNames.length > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최대 " + MAX_CAR_COUNT + "대까지 입력할 수 있습니다.");
        }

        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열이나 공백일 수 없습니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳과 숫자만 포함해야 합니다.");
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public static boolean isAlphanumeric(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0 || tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException("이동 횟수는 1 이상 " + MAX_TRY_COUNT + " 이하의 숫자여야 합니다.");
        }
    }
}
