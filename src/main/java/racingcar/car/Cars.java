package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.util.RandomGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, new RandomGenerator()));
        }
    }

    public void progress() {
        cars.forEach(Car::move);
    }

    public List<String> getRacingWinners() {
        final Car headCar = getFirstPositionCar();
        return getSamePositionCars(headCar);
    }

    public List<Car> getCars() {
        return cars.stream()
                .toList();
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

}
