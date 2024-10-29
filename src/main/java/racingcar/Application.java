package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        RacingCarController racingCarController = appConfig.racingCarController();
        racingCarController.run();
    }
}
