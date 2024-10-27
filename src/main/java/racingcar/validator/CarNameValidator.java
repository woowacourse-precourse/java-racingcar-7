package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

// 자동차 이름 유효성 검증 클래스
public class CarNameValidator {
    // 자동차 이름이 유효한지 전체적으로 검사
    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] names = carNames.split(",");
        validateUniqueNames(names);

        for (String name : names) {
            validateName(name.trim());
        }
    }

    // 각 이름에 대한 개별 검증
    private static void validateName(String name) {
        if (name.isEmpty() || !name.matches("[a-zA-Z가-힣]+")) {
            throw new IllegalArgumentException("자동차 이름은 공백이나 특수문자를 포함할 수 없습니다. (영어, 한글만)");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    // 이름의 중복성 확인
    private static void validateUniqueNames(String[] names) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name.trim())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name.trim());
            }
        }
    }
}

