package racingcar.factory;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> create(String carNames) {
        return Arrays.stream(splitCarNames(carNames))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] splitCarNames(String carNames) {
        validateInput(carNames);
        return validateCarNamesLength(carNames.split(","));
    }

    private static void validateInput(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    private static String[] validateCarNamesLength(String[] namesArray) {
        for (String name : namesArray) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1 ~ 5자만 가능합니다.");
            }
        }
        return namesArray;
    }
}