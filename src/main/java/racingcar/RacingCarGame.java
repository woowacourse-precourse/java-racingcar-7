package racingcar;

import racingcar.car.Cars;
import racingcar.car.Count;
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
        Cars cars = getCars();
        Count tryCount = getTryCount();
        printResult(cars, tryCount);
    }

    private void printResult(Cars cars, Count tryCount) {
        outputView.printGameResult(cars, tryCount);

        outputView.printWinner(cars);
    }

    private Count getTryCount() {
        outputView.requestTryCount();
        return inputView.getTryCount();
    }

    private Cars getCars() {
        outputView.requestCarNames();
        return inputView.getCarNames();
    }
}
