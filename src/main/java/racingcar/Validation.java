package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private Validation() {
    }

    public static void validateCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈칸일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public static void validateCarNamesList(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해야 합니다.");
        }
        checkForDuplicateNames(carNames);
        carNames.forEach(Validation::validateCarName);
    }

    public static void checkForDuplicateNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name);
            }
        }
    }

    public static void validateRoundsIsInteger(String input) {
        try {
            int rounds = Integer.parseInt(input);
            validateRounds(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }
    }
}
