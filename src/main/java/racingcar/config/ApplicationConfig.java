package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class ApplicationConfig {
    public RacingCarController racingCarController() {
        return new RacingCarController(
                new InputView()
        );
    }
}
