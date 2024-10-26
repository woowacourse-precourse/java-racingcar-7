package racingcar.util;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        if (!areValidName(carNames)) {
            throw new IllegalArgumentException("이름이 5글자가 넘습니다");
        }
        if (isNameOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    public static void validateRoundCount(String rawRoundInput) {
        if (!isValidRoundCount(rawRoundInput)) {
            throw new IllegalArgumentException("0 이상의 정수를 입력해주세요.");
        }
    }

    private static boolean areValidName(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= MAX_NAME_LENGTH);
    }

    private static boolean isNameOverlap(List<String> carNames) {
        return carNames.size() != new HashSet<>(carNames).size();
    }

    private static boolean isValidRoundCount(String rawRoundInput) {
        return rawRoundInput.matches("\\d+");
    }
}
