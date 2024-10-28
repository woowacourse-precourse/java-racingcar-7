package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarNameValidator carNameValidator = new CarNameValidator();

        GameController gameController = new GameController(inputView, outputView, carNameValidator);
        gameController.run();
    }

}
