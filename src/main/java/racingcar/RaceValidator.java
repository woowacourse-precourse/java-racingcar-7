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

    public static int validateCount(String input) {
        validateCountNotEmpty(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.", e);
        }
    }

    private static void validateCountNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
    }
}
