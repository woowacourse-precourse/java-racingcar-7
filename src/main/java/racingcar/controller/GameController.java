package racingcar.controller;

import java.util.List;
import racingcar.model.CarsManager;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.TrialsCountValidator;
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
        try {
            CarsManager cars = CarsManager.by(inputView.readCarNames());
            moveCars(cars);
            printWinners(cars);

        } catch (IllegalArgumentException exception) {
            throw exception;
        }
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