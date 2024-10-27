package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.view.View;

public class RacingController {
    private final View view;

    public RacingController() {
        this.view = View.create();
    }

    public void start() {
        Cars cars = createCarsFromUserInput();
    }

    private Cars createCarsFromUserInput() {
        String carNames = view.inputCarNames();
        return Cars.from(carNames);
    }
}
