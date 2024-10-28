package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_CAR_COUNT = 0;
    private static final int CAR_NAME_MIN_LENGTH = 5;

    public static void validateCarNames(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        validateCarsLength(cars);
        validateCarsNameLength(cars);
        duplicatedCarName(cars);
    }

    private static void validateCarsLength(String[] cars) {
        long validCarCount = Arrays.stream(cars)
                .filter(car -> !car.isBlank())
                .count();
        if (validCarCount == MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 한 대 이상이어야 합니다.");
        }
    }

    private static void validateCarsNameLength(String[] cars) {
        for (String car : cars) {
            checkCarNameLength(car);
        }
    }

    private static void checkCarNameLength(String car) {
        if (car.length() > CAR_NAME_MIN_LENGTH) {
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
