package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final RacingController racingController = new RacingController(inputView);

        racingController.run();
    }
}
