package controller;

import java.util.List;
import racingcar.Car;
import racingcar.Racing;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Racing racing = createRacing();
        playAllRacing(racing, inputView.inputAttemptCount());
        printWinner(racing);
    }

    public Racing createRacing() {
        List<Car> cars = inputView.inputCarNames();
        return new Racing(cars);
    }

    public void playAllRacing(Racing racing, int attemptCount) {
        outputView.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            racing.playRacing();
            outputView.printRacing(racing.racingInfo());
        }
    }

    public void printWinner(Racing racing) {
        outputView.finalWinners(racing.findWinners());
    }
}
