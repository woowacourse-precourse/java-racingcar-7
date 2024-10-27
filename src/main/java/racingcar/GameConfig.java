package racingcar;

public class GameConfig {
    public GameService gameService() {
        return new GameService();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }
    public InputValidator inputValidator() {
        return new InputValidator();
    }
    public GameController gameController() {
        return new GameController(gameService(), outputView(), inputView(), inputValidator());
    }
}
