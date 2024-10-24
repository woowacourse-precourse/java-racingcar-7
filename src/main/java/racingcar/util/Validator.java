package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        String[] namesArray = carNames.split(",", -1);
        if (namesArray.length == 1) {
            throw new IllegalArgumentException("자동차의 이름은 2개 이상 입력해 주세요.");
        }

        Arrays.stream(namesArray).forEach(Validator::validateCarName);

        Set<String> uniqueNames = new HashSet<>(Arrays.asList(namesArray));
        if (uniqueNames.size() != namesArray.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public static void validateAttempts(String attempts) {
        try {
            int attemptCount = Integer.parseInt(attempts);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}
