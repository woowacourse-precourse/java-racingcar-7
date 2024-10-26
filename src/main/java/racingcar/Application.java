package racingcar;

import racingcar.controller.NumberParser;
import racingcar.controller.RacingController;
import racingcar.controller.StringSplitter;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(
                new InputView(),
                new OutputView(),
                new RacingService(),
                new StringSplitter(),
                new NumberParser()

        );

        racingController.run();
    }
}
