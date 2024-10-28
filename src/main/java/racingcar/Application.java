package racingcar;

import racingcar.config.AppConfig;
import racingcar.manager.RacingManager;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        RacingCarLauncher racingCarLauncher = appConfig.racingCarLauncher();
        racingCarLauncher.start();
    }
}
