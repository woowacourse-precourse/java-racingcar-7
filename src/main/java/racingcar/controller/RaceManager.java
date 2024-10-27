package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String carNamesInput = inputView.readCarNames();
        String tryCountInput = inputView.readTryCount();

        Cars cars = new Cars(carNamesInput);
        TryCount tryCount = new TryCount(tryCountInput);

        outputView.displayRaceResult();
        int currentTryCount = 0;
        while (tryCount.isNotSame(currentTryCount)) {
            cars.race();

            outputView.displayRaceProgress(cars.getCars());
            currentTryCount++;
        }
    }
}
