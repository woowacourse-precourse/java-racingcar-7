package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final Cars cars;

    public RaceController() {
        final String carNames = inputCarNames();
        this.cars = new Cars(carNames);
    }

    private String inputCarNames() {
        return InputView.inputCarName();
    }

    public int inputTryCount() {
        return InputView.inputTryCount();
    }

    public void start() {
        cars.startRacing();
    }

    public void printResult() {
        OutputView.printResult(cars);
    }

    public void printWinner() {
        OutputView.printWinner(cars.findWinner());
    }
}
