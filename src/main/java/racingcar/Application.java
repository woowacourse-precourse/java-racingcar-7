package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        RacingGameController racingGameController = appConfig.racingCarController();
        racingGameController.run();
    }
}
