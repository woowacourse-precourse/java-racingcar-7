package racingcar;

import controller.MainController;
import controller.RacingCarService;
import factory.CarFactory;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarFactory carFactory = new CarFactory();
        RacingCarService racingCarService = new RacingCarService(outputView);

        MainController mainController = new MainController(inputView, outputView, carFactory, racingCarService);
        mainController.run();

    }
}
