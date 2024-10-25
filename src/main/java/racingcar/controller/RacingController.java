package racingcar.controller;

import racingcar.inputview.InputHandler;
import racingcar.outputview.OutputHandler;
import racingcar.service.CarManager;
import racingcar.service.GameManager;


public class RacingController {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    CarManager carManager;
    GameManager gameManager;

    public RacingController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.carManager = new CarManager();
    }

    public void run() {

        String[] carNames = getCarNamesFromUserInput();
        int attemptGameCount = getGameCountFromUserInput();

        gameManager = new GameManager(carNames, attemptGameCount);

        outputHandler.showGameResult();

        while(!gameManager.isGameOver()){
            gameManager.playGame();
            outputHandler.showCurrentCarPosition(gameManager.getCars());
        }

        outputHandler.showWinners(gameManager.getWinners());
    }

    private String[] getCarNamesFromUserInput(){
        outputHandler.promptCarNameInput();
        return inputHandler.split();
    }

    private int getGameCountFromUserInput(){
        outputHandler.promptAttemptCountInput();
        return inputHandler.getAttemptGameCount();
    }

}
