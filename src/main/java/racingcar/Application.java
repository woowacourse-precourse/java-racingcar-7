package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.model.Register;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Register register = new Register();
        CarRacingController carRacingController = new CarRacingController(inputView, outputView, register);
        carRacingController.race();
    }
}
