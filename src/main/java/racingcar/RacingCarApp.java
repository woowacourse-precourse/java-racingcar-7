package racingcar;

import racingcar.view.input.InputValueContainer;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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
        InputValueContainer inputValueContainer = inputView.readInput();
        racingCarGame = new RacingCarGame(inputValueContainer);
    }
}
