package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final RaceController raceController = new RaceController();
        final int tryCount = raceController.inputTryCount();
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            raceController.start();
            raceController.printResult();
        }
        raceController.printWinner();
    }
}
