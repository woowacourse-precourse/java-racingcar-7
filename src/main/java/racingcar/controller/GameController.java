package racingcar.controller;

import racingcar.model.CarsManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private OutputView outputView;
    private InputView inputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

            CarsManager cars = CarsManager.by(inputView.readCarNames());
            moveCars(cars);
            printWinners(cars);

    }
    private void moveCars(CarsManager cars) {
        int numberOfTrials = inputView.readTrialsCount();
        outputView.printResult();
        for (int trial = 0; trial < numberOfTrials; trial++) {
            moveCarsOnce(cars);
        }
    }
    private void moveCarsOnce(CarsManager cars) {
        cars.move();
        outputView.printRacing(cars);
    }
    private void printWinners(CarsManager cars) {
        outputView.printWinners(cars);
    }

}