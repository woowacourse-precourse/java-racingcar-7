package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.Constant;
import racingcar.util.RandomGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(name -> new Car(name, new RandomGenerator()))
                .toList();
    }

    public void updateCarsMovement() {
        cars.forEach(Car::move);
    }

    public List<String> getRacingWinners() {
        final Car headCar = getFirstPositionCar();
        return getSamePositionCars(headCar);
    }

    private List<String> getSamePositionCars(Car headCar) {
        return cars.stream()
                .filter(headCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private Car getFirstPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(Constant.CARS_EMPTY_ERROR_STRING));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

}
