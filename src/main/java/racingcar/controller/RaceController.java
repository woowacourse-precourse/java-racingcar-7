package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.judge.WinnerFinder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final int tryCount;
    private final String carNames;

    public RaceController() {
        this.carNames = inputCarNames();
        this.tryCount = initTryCount();
    }

    public void execute() {
        final Cars cars = createCars();
        OutputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            cars.startRacing();
            OutputView.printResult(cars);
        }

        printWinner(cars);
    }

    private Cars createCars() {
        return new Cars(carNames);
    }

    private void printWinner(final Cars cars) {
        final WinnerFinder winnerFinder = new WinnerFinder(cars);
        OutputView.printWinner(winnerFinder.find());
    }

    private String inputCarNames() {
        try {
            return InputView.inputCarName();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }

    private int initTryCount() {
        try {
            return InputView.inputTryCount();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
