package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.Constant;
import racingcar.util.RandomGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(final List<String> names) {
        return new Cars(toCars(names));
    }

    public List<String> getRacingWinners() {
        return findSamePositionCars(getFirstPositionCar());
    }

    public String getRacingProgress() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.joining("\n")) + "\n";
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    private static List<Car> toCars(final List<String> names) {
        return names.stream()
                .map(name -> new Car(name, new RandomGenerator()))
                .toList();
    }

    private List<String> findSamePositionCars(final Car headCar) {
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

}
