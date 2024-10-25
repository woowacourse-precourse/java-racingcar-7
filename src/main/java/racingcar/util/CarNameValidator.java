package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }


    public static void validateCarNames(List<String> carNames) {
        validateNotEmptyList(carNames);
        for (String carName : carNames) {
            validateEmptyName(carName);
            validateNameLength(carName);
        }
        validateDistinctName(carNames);
    }

    private static void validateNotEmptyList(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("빈 자동차 이름 목록입니다.");
        }
    }

    private static void validateEmptyName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘길 수 없습니다.");
        }
    }

    private static void validateDistinctName(List<String> carNames) {
        Set<String> distinctCarNames = new HashSet<>(carNames);
        if (carNames.size() != distinctCarNames.size()) {
            throw new IllegalArgumentException("동일한 자동차 이름이 존재합니다.");
        }
    }
}
