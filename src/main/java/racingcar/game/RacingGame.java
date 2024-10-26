package racingcar.game;

import racingcar.data.GameData;
import racingcar.io.InputHandler;

public class RacingGame {
    private final InputHandler inputHandler = new InputHandler();
    private final GameData gameData = new GameData();
    public void run() {
        String[] carNames = inputHandler.getCarNames();
        int tryNum = inputHandler.getTryNum();

        RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.prepareGameRounds(tryNum, carNames);
        racingGameManager.startGame(gameData);
    }
}
