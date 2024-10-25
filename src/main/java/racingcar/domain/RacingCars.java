package racingcar.domain;

import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static RacingCars from(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(car -> Car.from(Name.from(car)))
                .toList();
        return new RacingCars(cars);
    }
}
