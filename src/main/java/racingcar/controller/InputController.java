package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.Racing;
import racingcar.model.RoundNumberValidator;
import racingcar.view.InputView;

public class InputController {
    public static Racing setRacingCars() {
        CarNameValidator validator = new CarNameValidator(InputView.carInput());
        return new Racing(validator.cars);
    }
    public static int setRoundNumber(){
        RoundNumberValidator validator = new RoundNumberValidator(InputView.roundInput());
        return validator.roundNumber;
    }
}
