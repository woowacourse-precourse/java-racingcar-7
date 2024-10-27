package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessor {
    public static List<Car> parseToCarNameList(String inputString) {
        List<Car> cars = Arrays.stream(inputString.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());

        Validator.validateCarNames(cars);
        return cars;
    }

    public static int parseToAttemptCount(String attemptCountInput) {
        Validator.validateAttemptCount(attemptCountInput);
        return Integer.parseInt(attemptCountInput);
    }
}
