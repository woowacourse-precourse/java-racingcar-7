package racingcar.model;

import java.util.List;
import racingcar.utils.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    public List<CarName> getFinalWinners() {
        return this.cars.stream()
                .filter(car -> car.getDistance() == findMaxDistance())
                .map(Car::getCarRacer)
                .toList();
    }

    public void doOneCycle() {
        for (Car car : cars) {
            car.decideToGo(RandomNumberGenerator.getRandomNumber());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private int findMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }

    private void validateCars(List<Car> cars) {
        validateEmpty(cars);
        validateDuplication(cars);
    }

    private void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Car> cars) {
        if (isDuplicated(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Car> cars) {
        return cars.size() != cars.stream().distinct().count();
    }
}
