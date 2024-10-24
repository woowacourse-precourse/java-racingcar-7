package racingcar.service;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

public class DataTransformService {

    public List<String> splitInput(final String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public List<Car> convertToCar(List<String> carNames) {
        return carNames.stream().map(c -> new Car(c, 0)).toList();
    }
}
