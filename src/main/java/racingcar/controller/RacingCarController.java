package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void race(Cars cars, int attempsCount) {
        outputView.printResultMessage();
        for (int i = 0; i < attempsCount; i++) {
            cars.raceGame();
            outputView.printCarStatus(cars.getCarNames(), cars.getCarPositions());
        }
    }
}
