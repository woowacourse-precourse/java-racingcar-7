package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRacingController carRacingController = new CarRacingController();
        carRacingController.inputNames();
        carRacingController.inputCount();
    }
}
