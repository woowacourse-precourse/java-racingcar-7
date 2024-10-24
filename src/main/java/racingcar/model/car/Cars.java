package racingcar.model.car;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (hasDuplicateCar(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateCar(List<Car> cars) {
        return cars.stream().distinct().count() != cars.size();
    }
}
