package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = new Cars(inputView.receiveName());
        int count = inputView.receiveCount();

        outputView.printRaceResultPhrase();
        for (int i = 0; i < count; i++) {
            race(cars);
        }

        finish(cars);
    }

    private void race(Cars cars) {
        cars.move();
        outputView.printCars(cars);
    }

    private void finish(Cars cars) {
        outputView.printWinners(cars.findWinners());
    }
}
