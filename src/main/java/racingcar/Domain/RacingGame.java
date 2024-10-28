package racingcar.Domain;

import racingcar.Viewinterface.InputView;
import racingcar.Viewinterface.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private MoveCount moveCount;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void initialize() {
        inputView.carNameInput();
        cars = new Cars(inputView.readCarNames());

        inputView.requestMoveCount();
        moveCount = new MoveCount(inputView.readMoveCount());
    }

    private void race() {
        outputView.printRaceResult();
        for (int i = 0; i < moveCount.getValue(); i++) {
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
