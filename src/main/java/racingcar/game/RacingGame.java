package racingcar.game;

import racingcar.data.GameData;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingGame {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final GameData gameData = new GameData();
    public void run() {
        outputHandler.printAskCarNames();
        String[] carNames = inputHandler.getCarNames();

        outputHandler.printAskTryNum();
        int tryNum = inputHandler.getTryNum();

        RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.prepareGameRounds(tryNum, carNames);
        racingGameManager.startGame(gameData);

        outputHandler.printCarsRacingResult(gameData);
    }
}
