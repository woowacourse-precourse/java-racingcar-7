package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public static List<Car> createCarsFromInput(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

}
