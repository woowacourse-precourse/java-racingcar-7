package racingcar.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CarFactory {

    public static List<Car> createCars(String names) {
        return Arrays.stream(names.split(","))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
