package racingcar.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}