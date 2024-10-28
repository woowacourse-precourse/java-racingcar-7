package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    public static Cars from(String input) {
        List<Car> carList = Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    private void validateCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
