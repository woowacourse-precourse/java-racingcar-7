package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {

        AppConfig config = new AppConfig();
        RacingController controller = config.getCarRacingController();
        controller.run();

    }
}
