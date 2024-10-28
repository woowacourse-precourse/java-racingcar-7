package racingcar;

import racingcar.controller.ApplicationController;
import racingcar.service.CarService;
import racingcar.service.Extractor;
import racingcar.service.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Extractor extractor = new Extractor();
        Validator validator = new Validator();
        CarService carService = new CarService();

        ApplicationController controller = new ApplicationController(carService, extractor, validator, inputView, outputView);
        controller.run();

    }
}
