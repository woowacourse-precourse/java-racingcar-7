package racingcar;

import java.util.List;

public class RaceValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateCarNameLength(name);  // 길이 검사
            validateCarNameNotEmpty(name); // 공백 검사
        }
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
        }
    }

    private static void validateCarNameNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }
}
