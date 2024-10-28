package racingcar.controller;

import racingcar.model.CarRacer;
import racingcar.model.InputProcessor;
import racingcar.view.InputView;

public class RacingGame {

    public RacingGame() {
    }

    public void start() {
        String carNames = ViewController.readCarNames();
        String moveCount = ViewController.readTryCount();

        InputProcessor inputProcessor = new InputProcessor(carNames, moveCount);

        CarRacer carRacer = new CarRacer(inputProcessor.getCarNames());
        carRacer.startRace(inputProcessor.getTryCount());

        ViewController.printWinners(carRacer.getWinners());

        InputView.closeRead();
    }
}
