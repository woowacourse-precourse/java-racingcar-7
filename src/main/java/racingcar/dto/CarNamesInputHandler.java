package racingcar.dto;

import racingcar.validator.CarNamesValidator;

import java.util.List;

public class CarNamesInputHandler {
    public static void handle(List<String> carNames) {
        CarNamesValidator.validateDuplicate(carNames);
        for (String name : carNames) {
            CarNamesValidator.validate(name);
        }
    }
}
