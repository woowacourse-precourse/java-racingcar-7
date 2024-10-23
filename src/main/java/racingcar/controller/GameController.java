package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        int attemptCount = inputView.getAttemptCount();

        Game game = new Game(carNames, attemptCount);
        while (game.isRunning()) {
            game.play();
        }
    }
}
        