package racingcar;

import controller.MainController;
import controller.RacingCarService;
import factory.CarFactory;
import view.InputHandler;
import view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        CarFactory carFactory = new CarFactory();
        RacingCarService racingCarService = new RacingCarService(outputHandler);

        MainController mainController = new MainController(inputHandler, outputHandler, carFactory, racingCarService);
        mainController.run();

    }
}
