package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarList {
    private final List<Car> cars;

    private CarList(List<Car> cars) {
        this.cars = cars;
    }

    public static CarList from(String carNames) {
        List<String> splits = splitCarNames(carNames);
        validate(splits);
        List<Car> cars = splits.stream()
                .map(Car::new)
                .toList();
        return new CarList(cars);
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private static void validate(List<String> splits) {
        Set<String> carNamesValidator = new HashSet<>();

        splits.forEach(carName -> {
            validateEmpty(carName);
            validateDuplication(carName, carNamesValidator);
        });
        if (splits.size() == 1) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private static void validateEmpty(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private static void validateDuplication(String carName, Set<String> carNamesValidator) {
        if (carNamesValidator.contains(carName)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
        carNamesValidator.add(carName);
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
