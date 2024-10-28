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

    public void play() {
        initialize();
        executeRace();
        announceResult();
    }

    private void initialize() {
        initializeCars();
        initializeMoveCount();
    }

    private void initializeCars() {
        inputView.carNameInput();
        cars = new Cars(inputView.readCarNames());
    }

    private void initializeMoveCount() {
        inputView.requestMoveCount();
        moveCount = new MoveCount(inputView.readMoveCount());
    }

    private void executeRace() {
        outputView.printRaceResult();
        executeAllRounds();
    }

    private void executeAllRounds() {
        int totalRounds = moveCount.getValue();
        for (int i = 0; i < totalRounds; i++) {
            executeOneRound();
        }
    }

    private void executeOneRound() {
        cars.move();
        outputView.printRoundResult(cars.getCars());
    }

    private void announceResult() {
        outputView.printWinners(cars.getWinners());
    }
}