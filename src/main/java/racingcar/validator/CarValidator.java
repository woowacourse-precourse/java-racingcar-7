package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateNameLength(String name) {
        if(name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public static void validateUniqueName(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if(uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복 불가능합니다.");
        }
    }
}
