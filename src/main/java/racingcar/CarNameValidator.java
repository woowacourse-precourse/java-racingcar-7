package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    public static void validate(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();

        for (String name : carNames) {
            name = name.trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 이름이 포함될 수 없다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없다.");
            }
        }
    }
}
