package racingcar.Controller;

import racingcar.Model.CarNameValidator;
import racingcar.Model.RacingCars;
import racingcar.Model.RoundNumValidator;
import racingcar.View.InputView;

public class InputController {
    public static RacingCars setRacingCars(){
        CarNameValidator carNameValidator = new CarNameValidator(InputView.inputCars());
        return new RacingCars(carNameValidator.names);
    }
    public static int setRoundNum(){
        RoundNumValidator roundNumValidator = new RoundNumValidator(InputView.inputRounds());
        return Integer.parseInt(roundNumValidator.ROUNDNUM_STRING);
    }
}
