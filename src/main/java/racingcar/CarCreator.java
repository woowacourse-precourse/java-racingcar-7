package racingcar;

import java.util.List;

public class CarCreator {

    public static List<Car> createCar(List<String> names) {
        return names.stream().map(Car::new).toList();
    }
}
