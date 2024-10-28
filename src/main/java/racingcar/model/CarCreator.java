package racingcar.model;

import java.util.List;

public class CarCreator {

    private static final CarCreator instance = new CarCreator();

    private CarCreator() {
    }

    public static CarCreator getInstance() {
        return instance;
    }

    public Cars createCars(final List<String> names, final CarMovementPolicy movementPolicy) {
        List<Car> cars = names.stream()
                .map(car -> new Car(Name.from(car), movementPolicy))
                .toList();
        return new Cars(cars);
    }
}