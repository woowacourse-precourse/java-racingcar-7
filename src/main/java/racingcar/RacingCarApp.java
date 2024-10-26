package racingcar;

import racingcar.view.input.InputValueContainer;
import racingcar.view.input.InputView;

public class RacingCarApp {

    private final InputView inputView = new InputView();
    private RacingCarGame racingCarGame;

    public void run() {
        readInput();
        racingCarGame.play();
    }

    private void readInput() {
        InputValueContainer inputValueContainer = inputView.readInput();
        racingCarGame = new RacingCarGame(inputValueContainer);
    }
}
