package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    private final String delimiter;

    public CarFactory(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<Car> getCars(String input) {
        String[] carNames = input.split(delimiter);
        return Arrays.stream(carNames).map(Car::new).toList();
    }
}
