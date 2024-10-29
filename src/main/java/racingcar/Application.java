package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        RaceController raceController = new RaceController(inputView, outputView);

        raceController.run();
    }
}
