package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public void start() {
        Cars cars = InputView.readCars();
        TryCount tryCount = InputView.readTryCount();
        playRace(cars, tryCount);
    }

    public void playRace(Cars cars, TryCount tryCount) {
        OutputView.printRaceResult();
        tryCount.repeat(() -> {
            cars.tryMoveAll();
            OutputView.printRaceProgress(cars);
        });
    }
}
