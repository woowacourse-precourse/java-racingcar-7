package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateCarNames(List<Car> carList) {
        Set<String> carNameSet = new HashSet<>();
        for (Car car : carList) {
            String carName = car.getCarName();
            validateCarNameLength(carName);
            validateCarNameIsEmpty(carName);
            validateCarNameDuplication(carNameSet, carName);
        }
    }

    public static void validateAttemptCount(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시행횟수가 양수가 아닙니다.");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
        }
    }

    private static void validateCarNameIsEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 공백으로 되어있습니다.");
        }
    }

    private static void validateCarNameDuplication(Set<String> carNameSet, String carName) {
        if (!carNameSet.add(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
