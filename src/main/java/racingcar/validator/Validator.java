package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
            }
        }
    }

    public static void validateNameFormat(List<String> carNames) {
        for (String name : carNames) {
            if (!name.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳 문자만 포함해야 합니다: " + name);
            }
        }
    }

    public static void validateUniqueNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 포함되면 안됩니다.");
        }
    }

    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
