package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.domain.game.GameManager;
import racingcar.domain.game.GameRule;
import racingcar.domain.game.WinnerCalculator;
import racingcar.domain.game.WootecoRule;
import racingcar.service.RacingGameService;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameRule gameRule() {
        return new WootecoRule();
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    public WinnerCalculator winnerDeterminer() {
        return new WinnerCalculator(gameRule());
    }

    public GameManager gameManager() {
        return new GameManager(gameRule(), numberGenerator(), winnerDeterminer());
    }

    public RacingGameService racingGameService() {
        return new RacingGameService(gameManager());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingGameController racingGameController() {
        return new RacingGameController(racingGameService(), inputView(), outputView());
    }
}
