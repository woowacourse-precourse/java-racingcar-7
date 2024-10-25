package racingcar.model;

import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public Cars findCarsByMoveCount(Integer maxMoveCount) {
        List<Car> targetCars = this.cars
                .stream()
                .filter(car -> Objects.equals(maxMoveCount, car.getMoveCount()))
                .toList();
        return new Cars(targetCars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
