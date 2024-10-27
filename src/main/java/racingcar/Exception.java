package racingcar;

import java.util.HashMap;

public class Exception {
    private static final String MUST_BE_5_CHARACTERS_OR_LESS = "자동차 이름이 5글자 이하여야 합니다.";
    private static final String MUST_BE_UNIQUE = "자동차 이름이 중복되지 않아야 합니다.";
    private static final int MAX_LENGTH = 5;

    public static void validateUnique(HashMap<String, Integer> carMap, String carName) {
        if (carMap.containsKey(carName)) {
            throw new IllegalArgumentException(MUST_BE_UNIQUE);
        }
    }

    public static void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MUST_BE_5_CHARACTERS_OR_LESS);
        }
    }
}
