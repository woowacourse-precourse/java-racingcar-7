package racingcar.controller;

import racingcar.view.CarsIntermediateView;

public class ControllerFactory {
    public static RacingCarController createController() {
        return new RacingCarController(
                new CarsIntermediateView()
        );
    }
}
