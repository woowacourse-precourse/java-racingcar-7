package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingGameController racingGameController() {
        return new RacingGameController(racingGameService(), inputView(), outputView(), inputValidator());
    }

    private RacingGameService racingGameService() {
        return new RacingGameService();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}

