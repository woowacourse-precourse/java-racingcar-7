package racingcar;

import racingcar.appConfig.AppConfig;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        GameController controller = appConfig.getGameController();
        controller.start();
    }
}
