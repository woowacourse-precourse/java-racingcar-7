package racingcar.controller;

import java.util.List;
import racingcar.domain.Name;
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
        outputView.printWinners(race(cars, count));
    }

    private List<Name> race(Cars cars, int count) {
        while (count-- > 0) {
            cars.move();
            outputView.printCars(cars);
        }

        return cars.win();
    }
}
