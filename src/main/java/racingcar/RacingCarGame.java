package racingcar;

import racingcar.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.requestCarNames();
        Cars cars = inputView.getCarNames();

        outputView.requestTryCount();
    }
}
