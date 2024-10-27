package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.CarFactory;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = setUpController();

        racingController.startGame();
    }

    private static RacingController setUpController() {
        InputView inputView = new InputView();
        CarFactory carFactory = new CarFactory();

        return new RacingController(inputView, carFactory);
    }
}
