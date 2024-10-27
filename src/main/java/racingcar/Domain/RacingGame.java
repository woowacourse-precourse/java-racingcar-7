package racingcar.Domain;

import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        initialize();
    }

    private void initialize() {
        inputView.requestMoveCount();
        cars = new Cars(inputView.readCarNames());
    }

}
