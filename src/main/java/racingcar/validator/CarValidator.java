package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {
    public static void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5 || name.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 하며, 쉼표(,)를 포함할 수 없습니다.");
        }
    }

    public static void validateUniqueNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
