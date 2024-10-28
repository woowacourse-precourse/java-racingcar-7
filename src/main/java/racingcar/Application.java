package racingcar;

import racingcar.application.CarRacingController;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        CarRacingController carRacingController = new CarRacingController(new InputView(), new OutputView());
        carRacingController.run();
    }
}