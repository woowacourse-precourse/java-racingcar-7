package racingcar.core.controller;

import racingcar.core.view.RacingView;

public class RacingController {

    private final RacingView racingView;

    public RacingController() {
        this.racingView = new RacingView();
    }

    public static RacingController getInstance() {
        return new RacingController();
    }

    public void run() {
        String cars = racingView.inputCars();
        String tryCount = racingView.inputTryCount();

        racingView.printRaceStart();
    }
}
