package racingcar.factory;

import racingcar.controller.RacingGameController;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameControllerFactory {
    public static RacingGameController createRacingGameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarNameValidator carNameValidator = new CarNameValidator();
        TryCountValidator tryCountValidator = new TryCountValidator();

        return new RacingGameController(inputView, outputView, carNameValidator, tryCountValidator);
    }
}
