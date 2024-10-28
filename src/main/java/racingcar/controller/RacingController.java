package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.inputview.InputHandler;
import racingcar.outputview.OutputHandler;
import racingcar.randomtutils.DefaultRandomGenerator;
import racingcar.randomtutils.RandomGenerator;
import racingcar.service.CarManager;
import racingcar.service.GameManager;


public class RacingController {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    CarManager carManager;
    GameManager gameManager;
    RandomGenerator randomGenerator;

    public RacingController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.carManager = new CarManager();
        this.randomGenerator = new DefaultRandomGenerator();
    }

    public void run() {

        String[] carNames = getCarNamesFromUserInput();
        int attemptGameCount = getGameCountFromUserInput();

        gameManager = new GameManager(carNames, attemptGameCount, randomGenerator);

        outputHandler.showGameResult();

        while (!gameManager.isGameOver()) {
            gameManager.playGame();
            outputHandler.showCurrentCarPosition(gameManager.getCars());
        }

        outputHandler.showWinners(gameManager.getWinners());
    }

    private String[] getCarNamesFromUserInput() {
        outputHandler.promptCarNameInput();
        String userInput = Console.readLine();
        return inputHandler.split(userInput);
    }

    private int getGameCountFromUserInput() {
        outputHandler.promptAttemptCountInput();
        String userInput = Console.readLine();
        return inputHandler.getAttemptGameCount(userInput);
    }
}
