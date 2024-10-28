package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkCarNamesNotEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해야 합니다.");
        }
    }

    public static void checkCarNamesUnique(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();
        for (var name : carNames) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name);
            }
        }
    }

    public static void checkCarNameLength(List<String> carNames) {
        for (var name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다: " + name);

            }
        }
    }

    public static int parseRoundCount(String roundCountInput) {
        try {
            return Integer.parseInt(roundCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");

        }
    }

    public static void checkRoundCountPositive(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
