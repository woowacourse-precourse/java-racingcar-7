package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.Constant;
import racingcar.util.RandomGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> names) {
        return new Cars(toCars(names));
    }

    public List<String> getRacingWinners() {
        final Car headCar = findFirstPositionCar();
        return findSamePositionCars(headCar);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    private static List<Car> toCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(name, new RandomGenerator()))
                .toList();
    }

    private List<String> findSamePositionCars(Car headCar) {
        return cars.stream()
                .filter(headCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private Car findFirstPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(Constant.CARS_EMPTY_ERROR_STRING));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n")) + "\n";
    }

}
