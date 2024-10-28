package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final InputValidator inputValidator = new InputValidator();
        final RacingCarController racingCarController = new RacingCarController(inputView, inputValidator);
        racingCarController.run();
    }
}
