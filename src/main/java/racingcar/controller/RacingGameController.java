package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }

    public void run() {
        try {
            String inputNames = InputView.getCarNames();
            int tryCount = InputView.getTryCount();

            RacingGame racingGame = racingGameService.initializeGame(inputNames);
            racingGameService.startRace(racingGame, tryCount);

            OutputView.printWinners(racingGame.getWinners());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
