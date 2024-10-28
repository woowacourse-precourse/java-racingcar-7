package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.createNewInstance();
        RaceController raceController = appConfig.getRaceController();
        raceController.run();
    }
}
