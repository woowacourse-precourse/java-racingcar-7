package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.NameSplitter;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(
                new InputView(),
                new NameSplitter()
        );

        racingController.run();
    }
}
