package controller;

import java.util.List;
import racingcar.Car;
import racingcar.Racing;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Racing racing;

    public void run() {
        setting();
        racing();
        printWinner();
    }

    public void setting() {
        List<Car> cars = inputView.inputCarNames();
        int attemptCount = inputView.inputAttemptCount();
        racing = new Racing(cars, attemptCount);
    }

    public void racing() {
        outputView.printf("%n실행 결과%n");
        for (int i = 0; i < racing.getAttemptCount(); i++) {
            racing.playRacing();
            outputView.printRacing(racing.racingInfo());
        }
    }

    public void printWinner() {
        outputView.finalWinners(racing.findWinners());
    }

}
