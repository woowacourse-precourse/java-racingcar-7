package racingcar.controller;

import racingcar.domain.Winners;
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
        outputView.printWinner(race(cars, count));
    }

    private Winners race(Cars cars, int count) {
        while (count-- > 0) {
            cars.move();
            outputView.printRaceResult(cars);
        }

        return new Winners(cars);
    }
}
