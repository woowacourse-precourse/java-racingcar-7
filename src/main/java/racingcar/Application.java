package racingcar;


import racingcar.config.AppConfig;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.getGameController();
        gameController.run();
    }
}
