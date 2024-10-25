package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceImpl;
import racingcar.validation.CarNamesValidator;
import racingcar.validation.CarNamesValidatorImpl;
import racingcar.validation.RaceCountValidator;
import racingcar.validation.RaceCountValidatorImpl;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class AppConfig {

    public RacingGameController racingCarController() {
        return new RacingGameController(racingCarService(), inputView(), outPutView(), attemptCountValidator());
    }

    public RacingGameService racingCarService() {
        return new RacingGameServiceImpl(carNameValidator());
    }

    public CarNamesValidator carNameValidator() {
        return new CarNamesValidatorImpl();
    }

    public RaceCountValidator attemptCountValidator() {
        return new RaceCountValidatorImpl();
    }

    public InputView inputView() {
        return new InputViewImpl();
    }

    public OutputView outPutView() {
        return new OutputViewImpl();
    }
}
