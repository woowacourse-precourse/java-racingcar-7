package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class ApplicationConfig {
    public RacingCarController racingCarController() {
        return new RacingCarController(
                new InputView(),
                new CarService()
        );
    }
}
