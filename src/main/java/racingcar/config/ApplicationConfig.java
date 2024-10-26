package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.CarService;
import racingcar.service.MessageService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationConfig {
    public RacingCarController racingCarController() {
        return new RacingCarController(
                new InputView(),
                new OutputView(),
                new CarService(),
                new RacingService(),
                new MessageService()
        );
    }
}
