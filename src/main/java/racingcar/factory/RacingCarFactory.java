package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.validator.RacingCarNameValidator;
import racingcar.validator.RacingCarRepeatCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarFactory {

    public static RacingCarController createRacingCarController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarNameValidator racingCarNameValidator = new RacingCarNameValidator();
        RacingCarRepeatCountValidator racingCarRepeatCountValidator = new RacingCarRepeatCountValidator();
        RacingCarService racingCarService = new RacingCarService(racingCarNameValidator);

        return new RacingCarController(inputView, outputView, racingCarService, racingCarRepeatCountValidator);
    }
}
