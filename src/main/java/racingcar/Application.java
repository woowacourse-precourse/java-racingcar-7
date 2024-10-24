package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.controller.RacingControllerImpl;

public class Application {
    public static void main(String[] args) {

        AppConfig config = new AppConfig();
        RacingControllerImpl controller = config.getCarRacingController();
        controller.run();

    }
}
