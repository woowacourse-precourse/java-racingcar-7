package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    // 자동차 이름 검증 로직
    public static void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            validateNotEmpty(trimmedName);
            validateMaxLength(trimmedName);
            validateUniqueName(trimmedName, uniqueNames);
        }
    }
    
    private static void validateNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    private static void validateMaxLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateUniqueName(String name, Set<String> uniqueNames) {
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException("자동차 이름에 중복이 없어야 합니다.");
        }
    }

    // 경주 횟수 검증 로직
    public static int validateRounds(String input) {
        int rounds = parseRounds(input);
        validatePositiveRounds(rounds);
        return rounds;
    }

    private static int parseRounds(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경주 횟수는 숫자여야 합니다.");
        }
    }

    private static void validatePositiveRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
        }
    }
}
