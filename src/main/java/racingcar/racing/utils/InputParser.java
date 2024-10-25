package racingcar.racing.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public static List<String> parseCarNames(String inputCar) {
        List<String> carNames = Arrays.stream(inputCar.split(",")).toList();
        return carNames.stream().filter(carName -> !carName.equals("")).collect(Collectors.toList());
    }
}
