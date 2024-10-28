package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.service.CarSetupService;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingGameController racingGameController() {
        return new RacingGameController(racingGameService(), inputView(), outputView(), carSetupService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private RacingGameService racingGameService() {
        return new RacingGameService(outputView());
    }

    private CarSetupService carSetupService() {
        return new CarSetupService(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}

