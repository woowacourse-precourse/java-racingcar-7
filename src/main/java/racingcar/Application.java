package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final RaceGameController raceGameController = new RaceGameController(inputView, outputView);

        raceGameController.run();
    }
}
