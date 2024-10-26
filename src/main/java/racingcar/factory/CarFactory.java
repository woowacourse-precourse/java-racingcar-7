package racingcar.factory;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> create(String carNames) {
        return Arrays.stream(validateCarNames(carNames))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] validateCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 null 또는 빈 문자열일 수 없습니다.");
        }

        String[] namesArray = carNames.split(",");
        for (String name : namesArray) {
            String trimmedName = name.trim();
            if (trimmedName.length() < 1 || trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 1 ~ 5자만 가능합니다.");
            }
        }
        return namesArray;
    }
}