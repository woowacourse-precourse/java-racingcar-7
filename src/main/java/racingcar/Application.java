package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.CarFactory;
import racingcar.model.Judge;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = setUpController();

        racingController.startGame();
    }

    private static RacingController setUpController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarFactory carFactory = new CarFactory();
        Judge judge = new Judge();

        return new RacingController(inputView, outputView, carFactory, judge);
    }
}
