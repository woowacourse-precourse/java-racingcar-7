package racingcar;

import racingcar.controller.GameController;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(validator, inputView, outputView);
        gameController.startGame();
    }
}
