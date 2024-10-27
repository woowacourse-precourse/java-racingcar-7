package racingcar;

import racingcar.controller.InputController;
import racingcar.validator.InputValidator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final InputValidator inputValidator = new InputValidator();
        final InputController inputController = new InputController(inputView, inputValidator);
        inputController.run();
    }
}
