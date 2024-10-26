package racingcar;

import racingcar.Controller.RaceProcessController;
import racingcar.Controller.RaceViewController;
import racingcar.Factory.ControllerFactory;
import racingcar.Factory.DomainFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ControllerFactory controllerFactory = new ControllerFactory();

        RaceViewController viewController = controllerFactory.createRaceViewController();

        RaceProcessController processController = controllerFactory.createRaceProcessController(viewController);

        processController.run();
    }
}
