package racingcar;

import java.util.*;

public class RaceValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateCarNameLength(name);  // 길이 검사
            validateCarNameNotEmpty(name); // 공백 검사
        }
        validateCarNameDuplication(carNames);
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

    private static void validateCarNameDuplication(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복된 값이 있습니다.");
        }
    }

    public static int validateCount(String input) {
        validateCountNotEmpty(input);

        try {
            int count = Integer.parseInt(input);

            validateCountPositive(count);

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해주세요.", e);
        }
    }

    private static void validateCountNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
    }

    private static void validateCountPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("0보다 큰 정수를 입력해주세요.");
        }
    }
}
