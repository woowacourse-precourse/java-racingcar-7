package racingcar.model;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        // 쉼표 이외의 다른 구분자가 사용된 경우 예외 처리
        if (input.matches(".*[^a-zA-Z0-9,\\s].*")) {
            throw new IllegalArgumentException("자동차 이름을 쉼표로 구분해야 합니다.");
        }

        String[] carNames = input.split(",");

        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
        }

        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("빈 이름이 포함되어 있습니다.");
            }
            if (!nameSet.add(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
        }
    }

    public static void validateRoundInput(String input) {
        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}