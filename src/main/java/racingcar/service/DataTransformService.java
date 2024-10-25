package racingcar.service;

import static racingcar.util.ConstCharacter.CAR_DELIMITER;
import static racingcar.util.ConstNumber.PRIME_CAR_DISTANCE;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

public class DataTransformService {

    public List<String> splitInput(final String input) {
        return Arrays.stream(input.split(String.valueOf(CAR_DELIMITER.getCharacter()))).toList();
    }

    public List<Car> convertToCar(List<String> carNames) {
        return carNames.stream().map(c -> new Car(c)).toList();
    }

    public int parseToInt(String input) {
        return Integer.parseInt(input);
    }
}
