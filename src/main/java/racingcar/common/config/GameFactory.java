package racingcar.common.config;

import racingcar.controller.GameController;
import racingcar.service.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.service.GameService;

public class GameFactory {
    private static GameService createGameService() {
        return new GameService();
    }

    private static OutputView createOutputView() {
        return new OutputView();
    }

    private static InputView createInputView() {
        return new InputView();
    }

    private static InputValidator createInputValidator() {
        return new InputValidator();
    }

    public static GameController createGameController() {
        return new GameController(
                createGameService(),
                createOutputView(),
                createInputView(),
                createInputValidator()
        );
    }
}

