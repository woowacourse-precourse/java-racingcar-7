package racingcar.controller;

import racingcar.domain.CarsParser;
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
        RacingGame racingGame = createRacingGame();
        TryRound tryRound = createRacingRound();

        outputView.printStartGame();
        while (tryRound.isNotFinish()) {
            racingGame.proceedRound();
            outputView.printCurrentResult(racingGame.getCurrentRoundResult());

            tryRound.moveToNextRound();
        }

        outputView.printWinner(racingGame.findWinnerCarNames());
    }

    private RacingGame createRacingGame() {
        CarsParser carsParser = new CarsParser();
        String carNames = inputView.readCarNames();
        
        return new RacingGame(carsParser.parse(carNames));
    }

    private TryRound createRacingRound() {
        return new TryRound(inputView.readTryRound());
    }
}
