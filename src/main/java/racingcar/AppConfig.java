package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RegisterService;

public class AppConfig {
    public RacingGameController racingGameController() {
        return new RacingGameController(registerService());
    }

    public RegisterService registerService() {
        return new RegisterService();
    }
}
