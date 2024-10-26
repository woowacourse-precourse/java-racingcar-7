package racingcar.car.factory;

import racingcar.car.Car;

import java.util.LinkedHashSet;
import java.util.Set;

public class CarFactory {
    public static Set<Car> createCars(String input) {
        String[] names = input.split(",");
        Set<Car> cars = new LinkedHashSet<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}
