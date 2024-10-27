package racingcar;

import racingcar.config.Config;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        FrontController frontController = config.frontController();
        frontController.run();
    }
}
