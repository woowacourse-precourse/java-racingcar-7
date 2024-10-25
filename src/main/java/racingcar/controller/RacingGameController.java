package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.TryRound;
import racingcar.util.RandomDigitGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = new RacingGame(inputView.readCarNames(), new RandomDigitGenerator());
        TryRound tryRound = new TryRound(inputView.readTryRound());

        outputView.printStartGame();
        while (tryRound.isNotFinish()) {
            outputView.printCurrentResult(racingGame.proceedRound());

            tryRound.moveToNextRound();
        }

        outputView.printWinner(racingGame.findWinnerCarNames());
    }
}
