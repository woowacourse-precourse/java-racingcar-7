package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.application.GameApplication;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameApplication gameApplication = new GameApplication(appConfig);
        gameApplication.run();
    }
}
