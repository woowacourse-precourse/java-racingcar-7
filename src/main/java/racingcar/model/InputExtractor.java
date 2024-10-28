package racingcar.model;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputExtractor {
    public List<Car> extractCars(String input) {
        return Arrays.stream(input.split(","))
                .map(str -> new Car(str, 0))
                .collect(Collectors.toList());
    }
}
