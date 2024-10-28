package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;
    private final int tryCount;

    public RacingGameController() {
        this.racingGame = initallizeRacingGame();
        this.tryCount = InputView.inputTryCount();
    }

    private RacingGame initallizeRacingGame() {
        String carNames = InputView.inputCarNames();
        return new RacingGame(carNames, tryCount);
    }

    public void startRace() {
        OutputView.printInitialMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getAllCarStates());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
