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
        String inputNames = InputView.getCarNames();
        // initializeGame 메서드에서 예외가 발생하면 전파됨
        RacingGame racingGame = racingGameService.initializeGame(inputNames);
        int tryCount = InputView.getTryCount();
        racingGameService.startRace(racingGame, tryCount);
        OutputView.printWinners(racingGame.getWinners());
    }
}
