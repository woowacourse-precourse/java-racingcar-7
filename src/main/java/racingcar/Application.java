package racingcar;

import controller.CarController;
import controller.GameController;
import controller.MainController;
import factory.CarFactory;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarFactory carFactory = new CarFactory();
        RacingCarService racingCarService = new RacingCarService();

        CarController carController = new CarController(inputView, carFactory);
        GameController gameController = new GameController(racingCarService, outputView);
        MainController mainController = new MainController(carController, gameController);

        mainController.run();

    }
}
