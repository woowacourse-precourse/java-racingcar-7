package racingcar.controller;

import racingcar.view.CarsOutputView;

public class ControllerFactory {
    public static RacingCarController createController() {
        return new RacingCarController();
    }

    public static CarsOutputView createCarsOutputView() {
        return new CarsOutputView();
    }
}
