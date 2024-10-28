package racingcar.controller;

import racingcar.model.CarRacer;
import racingcar.model.InputFilter;
import racingcar.view.InputView;

public class RacingGame {

    public RacingGame() {
    }

    public void start() {
        String carNames = ViewController.inputCarNames();
        String moveCount = ViewController.inputTryCount();

        InputFilter inputFilter = new InputFilter(carNames, moveCount);

        CarRacer carRacer = new CarRacer(inputFilter.getCarNames());
        carRacer.moveCars(inputFilter.getMoveCount());

        ViewController.printWinners(carRacer.getWinners());

        InputView.closeRead();
    }
}
