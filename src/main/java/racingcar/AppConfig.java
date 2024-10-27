package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.service.RegisterService;
import racingcar.service.RoundService;
import racingcar.service.WinnerService;

public class AppConfig {
    public RacingGameController racingGameController() {
        return new RacingGameController(registerService(), roundService(), winnerService());
    }

    public RegisterService registerService() {
        return new RegisterService();
    }

    public RoundService roundService() {
        return new RoundService();
    }

    public WinnerService winnerService() {
        return new WinnerService();
    }


    public Cars cars() {
        return new Cars();
    }
}
