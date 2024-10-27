package racingcar.global;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static List<String> convertInputToCarNames(String input) {
        List<String> carNames = new ArrayList<>();
        for(String carName : input.split(",")) {
            carNames.add(carName.trim());
        }
        return carNames;
    }
}
