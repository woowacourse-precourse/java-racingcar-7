package racingcar;

import racingcar.Controller.RaceProcessController;
import racingcar.Controller.RaceViewController;
import racingcar.Factory.ControllerFactory;
import racingcar.Factory.DomainFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            DomainFactory domainFactory = new DomainFactory();
            ControllerFactory controllerFactory = new ControllerFactory(domainFactory);

            RaceViewController viewController = controllerFactory.createRaceViewController();
            RaceProcessController processController = controllerFactory.createRaceProcessController(viewController);

            processController.run();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
