package racingcar.model;

import java.util.List;
import racingcar.utils.RandomNumberGenerator;

public class Race {

    private static final String DUPLICATE_CAR_ERROR_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    private static final String CARS_COUNT_ERROR_MESSAGE = "2대 이상의 자동차를 입력해야합니다.";
    private static final int MINIMUM_CAR_COUNT = 2;
    private final List<Car> cars;

    public Race(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (hasDuplicateCar(cars)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_ERROR_MESSAGE);
        }
        if (hasNotEnoughCars(cars)) {
            throw new IllegalArgumentException(CARS_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicateCar(List<Car> cars) {
        return cars.stream().distinct().count() != cars.size();
    }

    private boolean hasNotEnoughCars(List<Car> cars) {
        return cars.size() < MINIMUM_CAR_COUNT;
    }

    public void progress() {
        cars.forEach(car -> moveCar(car, RandomNumberGenerator.generateNumber()));
    }

    private void moveCar(Car car, int number) {
        car.moveIfPossible(number);
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getLocation() == findMaxLocation())
                .toList();
    }

    private int findMaxLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
