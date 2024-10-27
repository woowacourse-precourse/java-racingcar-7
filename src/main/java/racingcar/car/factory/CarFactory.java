package racingcar.car.factory;

import racingcar.car.Car;

import java.util.LinkedHashSet;
import java.util.Set;

import static racingcar.message.ExceptionMessage.DUPLICATED_CAR_NAME;

public final class CarFactory {

    private CarFactory() {
    }

    public static Set<Car> createCars(String input) {
        String[] names = input.split(",");
        Set<Car> cars = new LinkedHashSet<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        checkDuplicated(names, cars);

        return cars;
    }

    private static void checkDuplicated(String[] names, Set<Car> cars) {
        if (names.length != cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getMessage());
        }
    }
}
