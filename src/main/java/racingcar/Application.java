package racingcar;

import controller.CarSetupController;
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

        CarSetupController carSetupController = new CarSetupController(inputView, carFactory);
        GameController gameController = new GameController(racingCarService, outputView);
        MainController mainController = new MainController(carSetupController, gameController);

        mainController.run();

    }
}
