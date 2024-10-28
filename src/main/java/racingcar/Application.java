package racingcar;

import racingcar.config.ControllerConfig;

public class Application {

    public static void main(String[] args) {
        ControllerConfig config = new ControllerConfig();
        config.controller().run();
    }

}
