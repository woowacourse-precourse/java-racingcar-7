package racingcar;

import racingcar.controller.NumberParser;
import racingcar.controller.RacingController;
import racingcar.controller.StringSplitter;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(
                new InputView(),
                new StringSplitter(),
                new NumberParser()
        );

        racingController.run();
    }
}
