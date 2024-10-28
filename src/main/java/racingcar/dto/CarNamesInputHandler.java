package racingcar.dto;

import racingcar.validator.CarNamesValidator;

import java.util.List;

public class CarNamesInputHandler {
    public static void handle(List<String> carNames) {
        if (carNames == null) {
            // At least a list is expected
            throw new IllegalArgumentException();
        }
        for (String name : carNames) {
            CarNamesValidator.validate(name);
        }
    }
}
