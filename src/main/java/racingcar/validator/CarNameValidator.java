package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private CarNameValidator() {}

    public static void validate(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        validateUniqueNames(names); // 중복 체크 추가
        for (String name : names) {
            validate(name);
        }
    }

    private static void validateUniqueNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
