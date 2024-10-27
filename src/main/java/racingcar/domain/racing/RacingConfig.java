package racingcar.domain.racing;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarType;

public class RacingConfig {
    private static final String carsDelimiter = ",";

    private final List<Car> cars;
    private final long rounds;

    public RacingConfig(String cars, String rounds, CarType cartype) {
        this.cars = registerCar(cars, cartype);
        this.rounds = Long.parseLong(rounds);
    }

    private List<Car> registerCar(String cars, CarType cartype) {
        return splitCarNames(cars).stream()
                .map(name -> CarFactory.create(name, cartype))
                .toList();
    }

    private List<String> splitCarNames(String cars) {
        return Arrays.stream(cars.split(carsDelimiter))
                .toList();
    }
}
