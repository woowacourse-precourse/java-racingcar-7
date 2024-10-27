package racingcar;

import racingcar.config.ControllerConfig;
import racingcar.controller.Controller;

public class Application {
    public static void main(String[] args) {
        ControllerConfig controllerConfig = ControllerConfig.getInstance();
        Controller controller = controllerConfig.getController();

        controller.ready();
        controller.runRace();
        controller.RaceResult();
    }
}
