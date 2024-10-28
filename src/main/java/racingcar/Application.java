package racingcar;

import racingcar.config.AppDIConfig;
import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        AppDIConfig appDIConfig = new AppDIConfig();
        RacingCarController racingCarController = appDIConfig.getRacingCarController();

        racingCarController.setRacingCar();
        racingCarController.startRacingGame();
        racingCarController.finalAward();
    }
}
