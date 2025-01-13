package controller;

import racingcar.AttemptCount;
import racingcar.Cars;
import racingcar.Racing;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            Racing racing = createRacing();
            playAllRacing(racing, AttemptCount.from(inputView.inputAttemptCount()));
            printWinner(racing);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Racing createRacing() {
        String carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);
        return new Racing(cars);
    }

    private void playAllRacing(Racing racing, int attemptCount) {
        outputView.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            racing.playRacing();
            outputView.printRacing(racing.racingInfo());
        }
    }

    private void printWinner(Racing racing) {
        outputView.finalWinners(racing.findWinners());
    }
}
