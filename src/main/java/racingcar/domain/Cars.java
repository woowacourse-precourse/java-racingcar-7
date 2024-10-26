package racingcar.domain;

import java.util.List;

import static racingcar.validator.CarCountValidator.validateCarCount;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<String> carNames) {
        this.cars = convertToCars(carNames);
    }

    public static Cars create(final List<String> carNames) {
        validateCarCount(carNames.size());
        return new Cars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach(Car::move);
    }

    private static List<Car> convertToCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
