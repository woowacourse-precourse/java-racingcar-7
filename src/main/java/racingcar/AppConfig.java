package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.service.RegisterService;
import racingcar.service.RoundService;

public class AppConfig {
    public RacingGameController racingGameController() {
        return new RacingGameController(registerService(), roundService());
    }

    public RegisterService registerService() {
        return new RegisterService();
    }

    public RoundService roundService() {
        return new RoundService();
    }

    public Cars cars() {
        return new Cars();
    }
}
