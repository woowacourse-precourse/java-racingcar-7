package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars;
        cars = InputCarsName();
    }

    private Cars InputCarsName() {
        String rawCarsName = inputView.inputCarNamesMessage();
        return new Cars(rawCarsName);
    }
}
