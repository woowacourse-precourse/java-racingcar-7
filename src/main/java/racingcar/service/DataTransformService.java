package racingcar.service;

import static racingcar.util.ConstCharacter.CAR_DELIMITER;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

public class DataTransformService {

    public List<String> splitInput(final String input) {
        return Arrays.stream(input.split(String.valueOf(CAR_DELIMITER.getCharacter()))).toList();
    }

    public List<Car> convertToCar(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public int parseToInt(String value) {
        return Integer.parseInt(value);
    }
}
