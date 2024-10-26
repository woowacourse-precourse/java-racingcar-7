package racingcar;

import racingcar.controller.ApplicationController;
import racingcar.controller.CarController;
import racingcar.model.Extractor;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Extractor extractor = new Extractor();
        Validator validator = new Validator();
        CarController carController = new CarController();

        ApplicationController controller = new ApplicationController(carController, extractor, validator, inputView, outputView);
        controller.run();

    }
}
