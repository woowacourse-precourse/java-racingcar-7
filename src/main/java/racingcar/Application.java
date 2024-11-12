package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.CarService;
import racingcar.model.StringParser;
import racingcar.model.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Validation validation = new Validation();
        StringParser stringParser = new StringParser(validation);
        CarService carService = new CarService();
        InputView inputView = new InputView(validation);
        OutputView outputView = new OutputView(validation);

        new RaceController(stringParser, carService, inputView, outputView).race();
    }
}
