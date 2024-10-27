package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.GameBoard;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void run() {
        GameBoard gameBoard = initializeGameBoard();
        AttemptNumber attemptNumber = initializeAttemptNumber();
    }

    private GameBoard initializeGameBoard() {
        String carNames = InputView.askCarName();
        return GameBoard.from(carNames);
    }

    private AttemptNumber initializeAttemptNumber() {
        String attemptNumberString = InputView.askAttemptNumber();
        return AttemptNumber.from(attemptNumberString);
    }

    private void play(GameBoard gameBoard, AttemptNumber attemptNumber) {
        int tryCount = 0;
        OutputView.printGameResultHeader();
        while(canPlay(tryCount, attemptNumber)) {
            OutputView.printEachGameResult(gameBoard.makeCarPositions());
            tryCount++;
        }
    }

    private boolean canPlay(int tryCount, AttemptNumber attemptNumber) {
        return tryCount == attemptNumber.getAttemptNumber();
    }
}
