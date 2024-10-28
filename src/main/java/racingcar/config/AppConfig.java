package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;

public class AppConfig {
    private static final InputValidator inputValidator = new InputValidator();
    private static final RacingGameService racingGameService = new RacingGameService();

    public static RacingGameController createRacingGameController() {
        return new RacingGameController(inputValidator, racingGameService);
    }
}

