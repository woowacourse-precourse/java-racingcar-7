package racingcar.domain;

import java.util.List;

import static racingcar.validator.CarCountValidator.validateCarCount;

public class Cars {
    private final List<Car> cars;

    private Cars(List<String> carNames) {
        this.cars = convertToCars(carNames);
    }

    public static Cars create(List<String> carNames) {
        validateCarCount(carNames.size());
        return new Cars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach(Car::move);
    }

    private static List<Car> convertToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
