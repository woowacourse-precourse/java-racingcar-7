package racingcar;

import controller.MainController;
import controller.RacingCarService;
import factory.CarFactory;
import view.InputView;
import view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputHandler outputHandler = new OutputHandler();
        CarFactory carFactory = new CarFactory();
        RacingCarService racingCarService = new RacingCarService(outputHandler);

        MainController mainController = new MainController(inputView, outputHandler, carFactory, racingCarService);
        mainController.run();

    }
}
