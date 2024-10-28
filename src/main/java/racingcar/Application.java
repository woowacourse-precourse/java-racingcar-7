package racingcar;

import racingcar.controller.GameController;
import racingcar.model.RacingGameFactory;
import racingcar.util.InputValidator;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        InputValidator inputValidator = new InputValidator();
        RacingGameFactory racingGameFactory = new RacingGameFactory();

        GameController controller = new GameController(inputView, outputView, inputValidator, racingGameFactory);
        controller.run();
    }
}
