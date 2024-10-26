package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {
    public static List<Car> generateFrom(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
