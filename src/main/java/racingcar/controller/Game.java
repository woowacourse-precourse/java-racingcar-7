package racingcar.controller;

import racingcar.domain.GameBoard;
import racingcar.view.InputView;

public class Game {
    public void run() {
        GameBoard gameBoard = initializeGameBoard();
    }

    private GameBoard initializeGameBoard() {
        String carNames = InputView.askCarName();
        return GameBoard.from(carNames);
    }
}
