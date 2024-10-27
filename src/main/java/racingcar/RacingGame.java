package racingcar;

import racingcar.view.InputView;

public class RacingGame {
    private final InputView inputView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.inputCarNameGuide();
    }

}
