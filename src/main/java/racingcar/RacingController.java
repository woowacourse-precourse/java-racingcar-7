package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void run() {
        Cars cars = InputView.readCars();
        int count = InputView.readCount();
        OutputView.showRacing(cars);
        startRacingGame(count, cars);
        OutputView.showResult(cars.getWinners());
    }

    private void startRacingGame(int count, Cars cars) {
        for (int i = 0; i < count; i++) {
            cars.moveAll();
            cars.showAll();
        }
    }
}
