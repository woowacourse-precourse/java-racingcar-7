package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {

    public static void validateCarNames(String carNames) {
        String[] cars = carNames.split(",");
        validateCarsLength(cars);
        validateCarsNameLength(cars);
        duplicatedCarName(cars);
    }

    private static void validateCarsLength(String[] cars) {
        if (cars.length <= 1 && cars[0].isBlank()) {
            throw new IllegalArgumentException("자동차는 한 대 이상이어야 합니다.");
        }
    }

    private static void validateCarsNameLength(String[] cars) {
        for (String car : cars) {
            checkCarNameLength(car);
        }
    }

    private static void checkCarNameLength(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private static void duplicatedCarName(String[] cars) {
        Set<String> duplicatedCars = new HashSet<>(List.of(cars));

        if (duplicatedCars.size() != cars.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
