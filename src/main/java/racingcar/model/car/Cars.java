package racingcar.model.car;

import java.util.List;

public class Cars {

    private static final int MINIMUM_CAR_COUNT = 2;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (hasDuplicateCar(cars) || hasNotEnoughCars(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateCar(List<Car> cars) {
        return cars.stream().distinct().count() != cars.size();
    }

    private boolean hasNotEnoughCars(List<Car> cars) {
        return cars.size() < MINIMUM_CAR_COUNT;
    }

    public List<Car> getCars() {
        return cars;
    }
}
