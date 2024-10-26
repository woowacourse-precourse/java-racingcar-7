package racingcar.controller;

import racingcar.model.GameManager;
import racingcar.model.InputProcessor;
import racingcar.model.ResultPrinter;

public class RacingCarController {
    public void startGame() {
        InputProcessor inputProcessor = new InputProcessor();
        GameManager gameManager = new GameManager();
        ResultPrinter resultPrinter = new ResultPrinter();

        var carNames = inputProcessor.getValidatedCarNames();
        int rounds = inputProcessor.getValidatedRounds();

        gameManager.setupGame(carNames, rounds);
        gameManager.playRounds();

        resultPrinter.printResults(gameManager.getCars(), gameManager.getWinners());
    }
}
