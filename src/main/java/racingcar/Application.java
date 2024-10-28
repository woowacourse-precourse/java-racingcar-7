package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        RacingGameController racingGameController = appConfig.racingGameController();
        racingGameController.run();
    }
}
