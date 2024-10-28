package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        RacingGame racingGame = new RacingGame(inputView.inputCarsName(), inputView.inputTryCount());
        outputView.printResultMessage();
        while (racingGame.getTryCount() > 0) {
            racingGame.start(randomMovingStrategy);
            outputView.printRacingProgress(racingGame);
        }
        outputView.printWinner(racingGame);
    }
}
