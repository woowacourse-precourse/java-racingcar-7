package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundValidator;
import racingcar.view.InputView;

import java.util.List;

public class InputController {

    public static final String DELIMITER = ",";

    public static CarRacing setCars() {
        String cars = InputView.inputCar();

        List<String> carList = List.of(cars.split(DELIMITER));

        CarNameValidator check = new CarNameValidator();

        check.rightNamePattern(cars);
        check.nameLength(carList);
        check.nameOverlap(carList);

        return new CarRacing(carList);
    }

    public static int setRound() {
        String round = InputView.inputRound();

        RoundValidator check = new RoundValidator();

        int number = check.parseInt(round);
        check.positiveNumber(number);

        return number;
    }
}
