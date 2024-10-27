package racingcar;

import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawCarNames) {
        this.cars = parseCarNames(rawCarNames);
    }

    private List<Car> parseCarNames(String rawCarNames) {
        return Stream.of(rawCarNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}
