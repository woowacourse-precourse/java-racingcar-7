package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNamesInput) {
        this.cars = registerCars(carNamesInput);
        validateCarsSize();
        validateNameDuplication();
    }

    private List<Car> registerCars(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(",", -1))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> moveCars() {
        cars.forEach(Car::move);
        return cars;
    }

    public List<String> findWinnerNames() {
        int maxMoveDistance = Collections.max(
                cars.stream()
                        .map(Car::getMoveDistance)
                        .collect(Collectors.toList())
        );
        return cars.stream()
                .filter(car -> car.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateNameDuplication() {
        Set<String> uniqueCarNames = new HashSet<>();
        for (Car car : cars) {
            if (!uniqueCarNames.add(car.getName())) {
                throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
            }
        }
    }

    private void validateCarsSize() {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }
    }
}
