package racingcar;

import racingcar.game.GameResult;
import racingcar.game.RacingCarGame;
import racingcar.view.input.InputValue;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarApp {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private RacingCarGame racingCarGame;

    public void run() {
        readInput();
        racingCarGame.play();
        GameResult gameResult = racingCarGame.getGameResult();
        outputView.printResult(gameResult);
    }

    private void init() {

    }

    private void readInput() {
        InputValue inputValue = inputView.readInput();
        racingCarGame = new RacingCarGame(inputValue);
    }
}
