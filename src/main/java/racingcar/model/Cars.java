package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateEmpty(cars);
        this.cars = cars;
    }

    public List<CarRacer> getFinalWinners() {
        return this.cars.stream()
                .filter(car -> car.getDistance() == findMaxDistance())
                .map(Car::getCarRacer)
                .toList();
    }

    private int findMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }

    private void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
