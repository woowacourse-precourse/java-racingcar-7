package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawCarsName) {
        this.cars = parseList(rawCarsName);
    }

    private List<Car> parseList(String rawCarsName) {
        String[] parts = rawCarsName.split(",");
        return Arrays.stream(parts)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
