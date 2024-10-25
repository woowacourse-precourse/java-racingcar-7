package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ProgressView;

public class RacingCarApplication {
    public static void run() {

    }

    private static RacingCarController initialize() {
        return new RacingCarController(
                new InputView(),
                new ProgressView(),
                new OutputView(),
                new Cars()
        );
    }
}
