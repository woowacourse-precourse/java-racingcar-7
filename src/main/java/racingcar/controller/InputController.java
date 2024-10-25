package racingcar.controller;

import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

import java.util.List;

public class InputController {

    public static final String DELIMITER = ",";

    public static List<String> setCars() {
        String cars = InputView.inputCar();

        List<String> carsList = List.of(cars.split(DELIMITER));

        CarNameValidator check = new CarNameValidator();

        check.rightNamePattern(cars);
        check.nameLength(carsList);
        check.nameOverlap(carsList);

        return carsList;
    }

}
