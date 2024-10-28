package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;

public class RaceController {
    public void start() {
        Cars cars = InputView.readCars();
        TryCount tryCount = InputView.readTryCount();
        playRace(cars, tryCount);
    }

    public void playRace(Cars cars, TryCount tryCount) {
        tryCount.repeat(() -> {

        });
    }
}
