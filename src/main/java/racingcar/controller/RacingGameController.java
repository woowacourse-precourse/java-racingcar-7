package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.TryRound;
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
        String carNames = inputView.readCarNames();
        RacingGame racingGame = new RacingGame(carNames);
        String finalRound = inputView.readTryRound();
        TryRound tryRound = new TryRound(finalRound);
        int currentRound = 1;
        outputView.printStartGame();

        while (tryRound.isNotFinish(currentRound)) {
            String currentProceedResult = racingGame.proceedRound();
            outputView.printCurrentResult(currentProceedResult);

            currentRound++;
        }

        outputView.printWinner(racingGame.findWinner());
    }
}
