package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController() {
        this.racingGame = initallizeRacingGame();
    }

    private RacingGame initallizeRacingGame() {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        return new RacingGame(carNames, tryCount);
    }

    public void startRace() {
        OutputView.printInitialMessage();
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getAllCarStates());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
