package racingcar;

import racingcar.config.AppConfig;
import racingcar.application.GameApplication;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameApplication gameApplication = new GameApplication(appConfig);
        gameApplication.run();
    }
}
