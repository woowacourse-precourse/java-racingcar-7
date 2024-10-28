package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.Racing;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Racing racing = new Racing(
                appConfig.inputView(),
                appConfig.outputView(),
                appConfig.racingManager(),
                appConfig.validator()
        );
        racing.start();
    }
}
