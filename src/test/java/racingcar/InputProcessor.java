package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    static List<Car> parseToCarNameList(String inputString) {
        List<String> carNames = Arrays.asList(inputString.split(","));
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            carName = carName.trim();
            cars.add(new Car(carName));
        }

        Validator.validateCarNames(cars);
        return cars;
    }

    public static int parseToAttemptCount(String attemptCountInput) {
        Validator.validateAttemptCount(attemptCountInput);
        return Integer.parseInt(attemptCountInput);
    }
}
