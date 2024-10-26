package racingcar.controller;

import racingcar.domain.CarRacing;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundValidator;
import racingcar.view.InputView;

public class InputController {

    public static CarRacing setCars() {
        CarNameValidator validator = new CarNameValidator(InputView.inputCar());
        validator.verify();

        return new CarRacing(validator.getCarList());
    }

    public static int setRound() {
        String round = InputView.inputRound();

        RoundValidator check = new RoundValidator();

        int number = check.parseInt(round);
        check.positiveNumber(number);

        return number;
    }
}
