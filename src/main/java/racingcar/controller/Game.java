package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.GameBoard;
import racingcar.view.InputView;

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
}
