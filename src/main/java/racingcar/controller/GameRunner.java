package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class GameRunner {
    private final OutputView outputView;

    public GameRunner(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run(RacingGame racingGame) {
        while (racingGame.hasMoreTrials()) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCars());
        }
        outputView.printWinners(racingGame.getWinners());
    }
}

