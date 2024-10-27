package racingcar;

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

