package racingcar.Domain;

import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private int moveCount;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void initialize() {
        inputView.carnameInput();
        cars = new Cars(inputView.readCarNames());

        inputView.requestMoveCount();
        moveCount = inputView.readMoveCount();
    }

    private void race() {
        outputView.printRaceResult();
        for (int i = 0; i < moveCount; i++) {
            cars.move();
            outputView.printRoundResult(cars.getCars());
        }
    }

    private void announceWinners() {
        outputView.printWinners(cars.getWinners());
    }

    public void play() {
        initialize();
        race();
        announceWinners();
    }

}
