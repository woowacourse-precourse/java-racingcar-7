package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class RaceController {
    public void start() {
        Cars cars = InputView.readCars();
    }
}
