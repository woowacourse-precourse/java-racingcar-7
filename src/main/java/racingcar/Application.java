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
        return new RacingController(new InputView(), new OutputView(), new CarFactory(), new Judge());
    }
}
