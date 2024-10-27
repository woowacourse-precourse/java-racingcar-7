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
        RoundValidator validator = new RoundValidator(InputView.inputRound());
        validator.verify();

        return validator.getRound();
    }
}
