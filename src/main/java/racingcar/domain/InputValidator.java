package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final Set<String> carNameSet = new HashSet<>();

    public static void validateCarNames(String carName) {
        validateLength(carName);
        validateDuplicates(carName);

        carNameSet.add(carName);
    }

    public static void validateRounds(int rounds) {
        if (rounds < 1) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
        }
    }

    private static void validateLength(String carName) {
        if (carName.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    private static void validateDuplicates(String carName) {
        if (carNameSet.contains(carName)) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }
}
