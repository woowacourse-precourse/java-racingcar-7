package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.validation.AttemptCountValidator;
import racingcar.validation.AttemptCountValidatorImpl;
import racingcar.validation.CarNamesValidator;
import racingcar.validation.CarNamesValidatorImpl;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class AppConfig {

    public RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(), inputView(), outPutView(), attemptCountValidator());
    }

    public RacingCarService racingCarService() {
        return new RacingCarServiceImpl(carNameValidator());
    }

    public CarNamesValidator carNameValidator() {
        return new CarNamesValidatorImpl();
    }

    public AttemptCountValidator attemptCountValidator() {
        return new AttemptCountValidatorImpl();
    }

    public InputView inputView() {
        return new InputViewImpl();
    }

    public OutputView outPutView() {
        return new OutputViewImpl();
    }
}
