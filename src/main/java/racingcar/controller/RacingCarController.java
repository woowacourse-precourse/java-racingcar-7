package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        Cars cars = readNames();
        int tryCount = readTryCount();
        startRacing(cars, tryCount);
    }

    private Cars readNames() {
        outputView.printCarNameMessage();
        return inputView.readCarNames();
    }

    private int readTryCount() {
        outputView.printTryCountMessage();
        return inputView.readTryCount();
    }

    private void startRacing(Cars cars, int tryCount) {
        RacingGame game = new RacingGame(cars, tryCount, new RandomNumberGenerator());
        outputView.printProgressGuide();
        while (game.isProgress()) {
            game.moveCars();
            outputView.printResult(cars.getResult());
        }
        outputView.printWinner(cars.getWinner());
    }
}
